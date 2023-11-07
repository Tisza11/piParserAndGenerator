package piConcurrent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WriteCode {
    /**
     * C és header fileok megírása
     * Ez alatt találhatóak a benne felhasznált fv-ek, amik azért lettek kirendezve, hogy átláthatóbb legyen az WriteCode()
     */
    static Fun mainFn;
    public static int Write_Code(){
        /*int LastLineInMain = */FindLastLines();
        SearchThreadChanges();
        int j = SearchFirstJoin();
//        /*int LastLineInMain = */FindLastLines();
        int eleje = TopOfCode();
//        System.out.println("\neleje: " + eleje);
        //ha pthread_create() fv-ben adott fv lett indítva a szálon,
        //csak majd annak az elején lesz beszúrva a szálkezeléshez szükséges fv eleji blokk
        for(int k = 0; k < Main.funok.size(); k++){
            for(int i = eleje; i < Main.sorok.size(); i++){
                if(Main.sorok.get(i).contains("pthread_create") && Main.sorok.get(i).contains(Main.funok.get(k).name)){
                    Main.funok.get(k).startedOnThread = true;
                }
            }
        }
        //sorok és hozzájuk tartozó részek összeállítása
        for(int i = eleje; i < Main.sorok.size(); i++){
//            if(j == (i + 1) && j > 0)Main.kod.append("    pthread_mutex_unlock(&piConcurrent_mutex);    //generated\n");
            //join előtt felszabadíztani a mutexet
            SetTheEndOfFunctions(i);
            if(Main.sorok.get(i).contains("pthread_join"))Main.kod.append(
                    "    locked = 0;    //generated\n" +
                    "    pthread_mutex_unlock(&piConcurrent_mutex);    //generated\n");
            Main.kod.append(Main.sorok.get(i));   /*<----------sor hozzáadás---------<<<<<*/
            Main.kod.append("\n");
            if(Main.sorok.get(i).contains("pthread_join"))Main.kod.append(
                    "    pthread_mutex_lock(&piConcurrent_mutex);    //generated\n" +
                    "    locked = 1;    //generated\n");
            SetAfterCreate(i);
            SetTheChange(i);
            SetTheStartOfFunctions(i);

            if(Main.sorok.get(i).contains("__VERIFIER_nondet_")){
                HianyosNondetKezel(i);
            }
            if(Main.sorok.get(i).contains("while(1)") || Main.sorok.get(i).contains("while(true)")){
                System.out.println("infinite loop");
                return -1;
            }
        }
        CleareFolder();
        WriteOut();
        return 0;
    }

    /**
     * Beállítja a threadChanged flaget ott, ahol van szálváltás (az új threadId-val rendelkező szálra)
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     */
    public static void SearchThreadChanges(){
        for(int i = 0; i < Main.edges.size(); i++){
            if(Main.edges.get(i).thread != -1){
                Main.szalelek.add(Main.edges.get(i));
            }
        }
        //ha adott élre történik az ugrás
        for (int i = 0; i < Main.szalelek.size() - 1; i++) {
            if(Main.szalelek.get(i).thread != Main.szalelek.get(i + 1).thread){
                Main.szalelek.get(i).threadChanges = true;
                System.out.println("\nchange thread from " + Main.szalelek.get(i).thread + " to " + Main.szalelek.get(i + 1).thread + "\n");
                System.out.println("Line " + Main.szalelek.get(i).startLine);
                System.out.println(Main.szalelek.get(i).isLastLine);
            }
        }
    }

    /**
     * A kód elejére írt importok, globális változók, amik előre adottak
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     */
    public static int TopOfCode(){
        int eleje = 0;
        for(int i = 0; i < Main.edges.size(); i++){
            if(eleje == 0) eleje = Main.edges.get(i).startLine;
            if(Main.edges.get(i).startLine < eleje && Main.edges.get(i).startLine != 0) eleje = Main.edges.get(i).startLine;
        }
        int lenyeg = 0;
        for (int i = 0; i < Main.funok.size(); i++) {
            if(eleje <= Main.funok.get(i).endLine && eleje >= Main.funok.get(i).startLine) lenyeg = Main.funok.get(i).startLine;
        }
        for(int i = 0; i < lenyeg - 1; i++){
            Main.kod.append(Main.sorok.get(i));   /*<----------sor hozzáadás---------<<<<<*/
            Main.kod.append("\n");
            if(Main.sorok.get(i).contains("__VERIFIER_nondet_")){
                HianyosNondetKezel(i);
            }
//            if(Main.sorok.get(i).contains("while(1)") || Main.sorok.get(i).contains("while(true)")){
//                return -1;
//            }
        }
        Main.kod.append(
                "#include \"nondetfvek.h\"    //generated\n" +
//                "#include <time.h>\n" +

                "\nint locked = 0;    //generated\n" +
                "pthread_mutex_t piConcurrent_mutex;    //generated\n" +
                        "pthread_cond_t piConcurrent_cond;    //generated\n" +
                        "int piConcurrent_flag;    //generated\n");
        //thread ID-kat tárolják
        for(int i = 0; i < Main.IDk.size(); i++){
            Main.kod.append("int piConcurrent_t");
            Main.kod.append(Main.IDk.get(i));
            Main.kod.append(" = -1;    //generated\n");
        }
        return lenyeg - 1;
    }

    /**
     * Megkeresi a (main-ben a) join első előfordulását --> (ez még lehet, hogy nem les így jó, ha két join között szükség lesz a mutexre)
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     * @return - megkeresi az ez első join-t a mainben
     */
    public static int SearchFirstJoin(){
        Pattern pattern;
        Matcher matcher;
        int start = 1;
        int end = 0;
        int sor = 0;
        for(int i = 0; i < Main.funok.size(); i++){
            if(Main.funok.get(i).name.equals("main")){
                start = Main.funok.get(i).startLine;
                end = Main.funok.get(i).endLine;
            }
        }
        pattern = Pattern.compile(".*pthread_join.*");
        matcher = pattern.matcher(Main.sorok.get(start - 1));
        while(start < end){
            if(matcher.find()){
                sor = start;
//                System.out.println("\nA sor " + sor);
                return sor;
            }
            start++;
            matcher = pattern.matcher(Main.sorok.get(start - 1));
        }
        return sor;
    }

    /**
     * Megtalálja minden thread utolsó futó (witnessben feltüntetett) sorát, majd azon beállítja a megfelelő flag-et
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     * @return - visszatér annak a sornak a számával, ami utoljára fut le a main-en belül
     */
    public static int FindLastLines(){
        //utolsó részek felderítése egyes fv-ekből, mainnél majd kicsit másképp
        int k = 0;/* = edges.size() - 1*;*/   //ha a lenti while ciklus lenne a for helyett
        int lastOfMain = 0;
        int idx = 0;
        for(int i = 0; i < Main.funok.size(); i++){
            if(Main.funok.get(i).name.equals("main")){
                idx = i;
                mainFn = Main.funok.get(i);
            }
        }
        for (int i = 0; i < Main.IDk.size(); i++) {
            //a for ciklusnál optimálisabbnak tűnik, de nincs még kipróbálva
//            while (k >= 0 && !(edges.get(k).Thread == idk.get(i))){
//                k--;
//            }
            for(int l = 0; l < Main.edges.size(); l++){
                if(Main.edges.get(l).thread == Main.IDk.get(i)){
                    if(Main.IDk.get(i) == 0){
                        if(Main.edges.get(l).startLine > Main.funok.get(idx).startLine && Main.edges.get(l).startLine < Main.funok.get(idx).endLine)
                            k = l;
                    }
                    else k = l;
                }
            }
            Main.lastLines.put(k, Main.edges.get(k).startLine);
            System.out.println("\nLast line of " + Main.edges.get(k).thread + ". thread: " + Main.edges.get(k).startLine);
            //k = edges.size(); //ha a while rész lenne a for ciklus helyett

            Main.edges.get(k).isLastLine = true;
        }
        Main.edges.get(Main.edges.size() - 1).isLastLine = true;
        return lastOfMain;
    }

    /**
     * A fv-ek utolsó futó sora elé/után hozzáadja a mutex, condition variable és várakozás miatti szükséges sorokat
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     * @param i - i-edik sorhoz kapja majd meg az indexet
     */
    public static void SetTheEndOfFunctions(int i){
        int idx = 0;
        int idxM = 0;
//        if(i == mainFn.endLine - 2){
//            Main.kod.append("    pthread_cond_destroy(&piConcurrent_cond);    //generated\n" +
//                            "    pthread_mutex_destroy(&piConcurrent_mutex);    //generated\n");
//        }
        //Megvizsgálja, hogy a lastLines Map-nek(k-dik él, StartLine), van-e olyan értéke (StartLine), ami i, tehát az i-dik sor szerepel-e az utolsó sorok között (i+1 a main miatt kell)
        if(Main.lastLines.containsValue(i) || Main.lastLines.containsValue(i + 1)){
            //végig megy a Map összes elemén, hogy kiderítse, hogy ahhoz az utolsó sorhoz milyen él index tartozik
            for (Map.Entry mapElement: Main.lastLines.entrySet()) {
                if((int)mapElement.getValue() == i){
                    //Ezen az élen van az utolsó sora egy fv-nek
                    idx = (int)mapElement.getKey();
                }
                if((int)mapElement.getValue() == (i + 1)){
                    //Ezen az élen van az utolsó sora egy fv-nek
                    idxM = (int)mapElement.getKey();
                }
            }
            //más, ha a main vége...
            if(Main.edges.get(idx/*M*/).thread == 0 && Main.lastLines.containsValue(i/* + 1*/)){
                if(idx != Main.edges.size() - 1)Main.kod.append("        piConcurrent_flag = piConcurrent_t" + Main.edges.get(idx + 1).thread + ";    //generated\n");
                Main.kod.append("    pthread_cond_destroy(&piConcurrent_cond);    //generated\n" +
                        "    pthread_mutex_destroy(&piConcurrent_mutex);    //generated\n");
            }
            //...és más, ha egyéb fv utolsó sora
            if(Main.edges.get(idx).thread != 0 && Main.lastLines.containsValue(i) && idx != Main.edges.size() - 1){
                Main.kod.append(
                        "    if(piConcurrent_maga == piConcurrent_t" + Main.edges.get(idx).thread + "){    //generated\n" +
                        "        piConcurrent_flag = piConcurrent_t" + Main.edges.get(idx + 1).thread + ";    //generated\n" +
                        "        pthread_cond_broadcast(&piConcurrent_cond);    //generated\n" +
                        "        pthread_mutex_unlock(&piConcurrent_mutex);    //generated\n" +
                        "    }    //generated\n");
            }
        }
    }

    /**
     * A pthread_create() sorok után a létrejött thread ID-ja kerül eltárolásra
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     * @param i - i-edik sorhoz kapja majd meg az indexet
     */
    public static void SetAfterCreate(int i){
        if(Main.sorok.get(i).contains("pthread_create")){
            for(int a = 0; a < Main.edges.size(); a++){
                int idx = Main.sorok.get(i).indexOf("&");
                String utan = Main.sorok.get(i).substring(idx);
                int idx2 = utan.indexOf(',');
                String threadNeve = Main.sorok.get(i).substring(idx + 1, idx + idx2);
                if(Main.edges.get(a).startLine == (i + 1)){
                    //if(Main.edges.get(a).createdThread < 0)
                    Main.kod.append("    piConcurrent_t" + Main.edges.get(a).createdThread + " = " + threadNeve /*Main.sorok.get(i).charAt(idx + 1)*/ + ";    //generated\n");
                }
            }
        }
    }

    /**
     * Ha a paraméterként kapott indexű sor után szál váltás történik (amivel még nem ér véget a szál), akkor a szálváltás menetét írja hozzá
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     * @param idx - i-edik sorhoz kapja majd meg az indexet
     */
    public static void SetTheChange(int idx){
//        for (Map.Entry mapElement: Main.lastLines.entrySet()) {
//            if((int)mapElement.getValue() == idx + 1 && (idx < mainFn.startLine || idx > mainFn.endLine)){
//                //Ha utolsó él, nem sima váltás következik
//                return;
//            }
//        }
        for (int i = 0; i < Main.szalelek.size(); i++){
            if(Main.szalelek.get(i).startLine == (idx + 1) && Main.szalelek.get(i).threadChanges && !Main.szalelek.get(i).isLastLine){
                System.out.println("\nHely: " + Main.szalelek.get(i).startLine + ", T: " + Main.szalelek.get(i + 1).thread);
                if(Main.szalelek.get(i).thread != 0){
                    Main.kod.append(
                                        "    if(piConcurrent_maga == piConcurrent_t" + Main.szalelek.get(i).thread + "){    //generated\n");
                }
                Main.kod.append(
                                        "        piConcurrent_flag = piConcurrent_t" + Main.szalelek.get(i + 1).thread +";    //generated\n" +
                                        "        pthread_cond_broadcast(&piConcurrent_cond);    //generated\n");
                if(Main.szalelek.get(i).thread == 0){
                    Main.kod.append(
                                        "    while (piConcurrent_flag != piConcurrent_t0) {    //generated\n");
                }
                else{
                    Main.kod.append(
                                        "        while (piConcurrent_flag != piConcurrent_maga || locked == 0) {    //generated\n");
                }
                Main.kod.append(
                                        "            pthread_cond_wait(&piConcurrent_cond, &piConcurrent_mutex);    //generated\n" +
                                        "        }    //generated\n");
                if(Main.szalelek.get(i).thread != 0){
                    Main.kod.append(
                                        "    }    //generated\n");
                }
            }
        }
    }

    /**
     * A fv-ek fejléce után hozzáadja a mutex, condition variable és várakozás miatti szükséges sorokat
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     * @param i - i-edik sort vizsgálja
     */
    public static void SetTheStartOfFunctions(int i){
        for(int k = 0; k < Main.funok.size(); k++){
            if(Main.funok.get(k).startCurly == i + 1 && !Main.funok.get(k).name.equals("main") && Main.funok.get(k).startedOnThread){
                Main.kod.append("    pthread_mutex_lock(&piConcurrent_mutex);    //generated\n" +
                                "    int piConcurrent_maga = pthread_self();    //generated\n" +
                                "    while (piConcurrent_flag != piConcurrent_maga) {    //generated\n" +
                                "        pthread_cond_wait(&piConcurrent_cond, &piConcurrent_mutex);    //generated\n" +
                                "    }    //generated\n");
            } else if (Main.funok.get(k).startCurly == i + 1 && !Main.funok.get(k).name.equals("main") && !Main.funok.get(k).startedOnThread) {
                Main.kod.append("    int piConcurrent_maga = pthread_self();    //generated\n");
            } else if(Main.funok.get(k).startCurly == i + 1 && Main.funok.get(k).name.equals("main")){
                Main.kod.append("    pthread_cond_init(&piConcurrent_cond, 0);    //generated\n" +
                            "    pthread_mutex_init(&piConcurrent_mutex, 0);    //generated\n" +
                            "    pthread_mutex_lock(&piConcurrent_mutex);    //generated\n" +
                            "    locked = 1;    //generated\n" +
                            "    piConcurrent_t0 = pthread_self();    //generated\n");
            }
        }
    }

    /**
     * Ha van bármi a mappában, kitörli
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     */
    public static void CleareFolder(){
        File tFolder = new File(Main.targetFolder);
        try{
            if(!tFolder.exists())
                new File(Main.targetFolder).mkdir();
        }catch (Exception e){

        }
        String[] files = tFolder.list();
        if(files == null) return;
        if(files.length > 0){
            final File[] fileok = tFolder.listFiles();
            for (File f: fileok) f.delete();
        }
    }

    /**
     * A header és c fileba beleírja a szükséges dolgokat
     * Azért lett kiszervezve, hogy a WriteCode() átláthatóbb legyen
     */
    public static void WriteOut(){
        //c file kiírása
        try {
            FileWriter myWriter = new FileWriter(Main.targetFolder + "/main.c");
            myWriter.write(Main.kod.toString());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Hiba van a kiiratassal.");
            e.printStackTrace();
        }
        //header file kiiratása
        try {
            FileWriter myWriter = new FileWriter(Main.targetFolder + "/nondetfvek.h");
            myWriter.write("//This file is generated\n" +
                    "#ifndef NONDETFVEK_H_INCLUDED\n" +
                    "#define NONDETFVEK_H_INCLUDED\n");
            myWriter.write(Main.headerbe.toString());
            myWriter.write("\nvoid __VERIFIER_atomic_begin(void){return;}\n");
            myWriter.write("\nvoid __VERIFIER_atomic_end(void){return;}\n");
            myWriter.write("#endif");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Hiba van a kiiratassal.");
            e.printStackTrace();
        }
    }

    public static void HianyosNondetKezel(int i){
        int nondetEleje = Main.sorok.get(i).indexOf("__VERIFIER_nondet_");
        int nondetVege = Main.sorok.get(i).indexOf("(", nondetEleje);
        String nondetFvType = Main.sorok.get(i).substring(nondetEleje + ("__VERIFIER_nondet_").length(), nondetVege);
//                System.out.println(nondetFvType);
//                System.out.println("\n\n__VERIFIER_nondet_\n\n");
        boolean tartalmazza = false;
        String header = Main.headerbe.toString();
        if(header.contains(nondetFvType)) tartalmazza = true ;
        if(!tartalmazza){
//                    System.out.println("\nHiasan nem lett jelolve " + nondetFvType);
            String nondetFv = "__VERIFIER_nondet_" + nondetFvType;
            if(nondetFvType.startsWith("u")) nondetFvType = "unsigned " + nondetFvType.substring(1);
            Main.headerbe.append("\n" + nondetFvType + " " + nondetFv + "(){ return 0;}\n");
        }
    }
}
