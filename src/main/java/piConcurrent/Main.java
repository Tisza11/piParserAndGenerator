package piConcurrent;

import org.xml.sax.SAXException;
import parser.Parse;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //C file elérési útja
    @Parameter(names = "--codeFile", required = true, description = "Ide add meg a .i file-t!")
    public static String codeFile;

    //élek adatainak eltárolása beolvasás után ebben
    static ArrayList<Edge> edges = new ArrayList<>();

    //élek listájának fenntartása ahhoz, hogy rendezve legyenek fv szerint
    public static ArrayList<Edge> edgesForInit = new ArrayList<>();

    //fv-ek tárolása (név, kezdő sor, utolsó sor)
    public static ArrayList<Fun> funok = new ArrayList<>();

    //witness file elérési útja
    @Parameter(names = "--gmlFile", required = true, description = "Ide add meg a witness file nevet!")
    public static String gmlFile;

    //ez a részlet fog bekerülni a C kódba a main elé, hogy futtatható legyen (nondet fv megvalósítások)
    public static StringBuilder headerbe = new StringBuilder();

    //thread ID-k
    static ArrayList<Integer> IDk = new ArrayList<>();

    //ebbe lesz kiirvava a C kód
    public static StringBuilder kod = new StringBuilder();

    //edge-nek a k-dik idx-e, StartLine
    static Map<Integer, Integer> lastLines = new HashMap<>();

    //soronként tárolva a kódot
    public static ArrayList<String> sorok = new ArrayList<>();

    //ebben a mappában van a .i és *.graphml file
//    @Parameter(names = "--sourceFolder", required = true, description = "Ide add meg a .i es .graphml fileokat tartalmazo mappa eleresi utjat!")
    public static String sourceFolder;

    //ebben vannak eltárolva azok az élek, amelyeken meg van adva threadID
    public static ArrayList<Edge> szalelek = new ArrayList<>();

//    //a jelenlegi szálat tárolja    //jelenleg nincs használva
//    public static int CurrentThread = 0;
    @Parameter(names = "--targetFolder", required = true, description = "Ide add meg a cel mappa eleresi utjat!")
    public static String targetFolder;
//    public static String targetFolder = "futasra";

    //létrehozott szálak azonosítói

    public static void main(final String[] args) throws ParserConfigurationException, IOException, SAXException {
        final Main mainApp = new Main();
        mainApp.run(args);
    }

    public void run(String[] args) throws ParserConfigurationException, IOException, SAXException {
        try {
            JCommander.newBuilder().addObject(this).programName("graphmlparser").build().parse(args);
        } catch (final ParameterException ex) {
            System.out.println("Invalid parameters, details:");
            System.out.println(ex.getMessage());
            ex.usage();
            return;
        }


        //sima futtataskor
//    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
//        sourceFolder = "C:\\egyetem masolat\\felev6\\Onlab\\c-probak\\";
////        sourceFolder = "/mnt/c/egyetem masolat/felev6/Onlab/c-probak/";
//        gmlFile = "C:\\egyetem masolat\\felev6\\Onlab\\c-probak\\l01_D.graphml"; //"witnessAzonos.graphml";
//        codeFile = "C:\\egyetem masolat\\felev6\\Onlab\\c-probak\\lazy01.i"; //"funok.i";
//        targetFolder = "C:\\egyetem masolat\\felev6\\Onlab\\futasra\\";
////        targetFolder = "/mnt/c/egyetem masolat/felev6/Onlab/futasra/";
        if(!ReadXML.Read_XML(gmlFile, codeFile)){
            System.out.println("correctness");
            System.out.println("\nhiba");
            return;
        }
//        System.out.println("Read xml done");
        InIt.Init();
//        System.out.println("Init done");
        ReadCode(/*codeFolder, */codeFile);
//        System.out.println("Read code done");
        ReadFuns();
//        System.out.println("Read funs done");
        Checker();
//        System.out.println("Checker done");
        int eleje = WriteCode.Write_Code();
        if(eleje == -1){
            System.out.println("vegtelen ciklus");
            return;
        }
        if(!CheckAtomic(eleje)){
            return;
        }
//        System.out.println("Write code done");
        CompileCprog();
//        System.out.println("Compile and run done");
    }


    /**
     * beolvasásra kerül a c/i file tartalma
     * @param codeFile ez a code file kerül beolvasásra
     */
    public static void ReadCode(/*String codeFolder, */String codeFile){
        try {
            File myFile = new File(/*sourceFolder +*/ codeFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                sorok.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba van a beolvasassal.");
            e.printStackTrace();
        }
    }

    /**
     * Megkeresi a használt fv-ek neveit, első és utolsó sorait
     */
    public static void ReadFuns() {
//        System.out.println(sourceFolder + codeFile);
        Parse.parse(/*sourceFolder +*/ codeFile);
        //fv-ek neve, kezdo es zaro sora
//        for (int i = 0; i < funok.size(); i++) {
//            System.out.println(funok.get(i).name);
//            System.out.println(funok.get(i).startLine);
//            System.out.println(funok.get(i).startCurly);
//            System.out.println(funok.get(i).endLine);
//        }
    }

    /**
     * C file átnézése, ha a witnessben nem derült ki, hogy milyen fgvt kell hívni
     */
    public static void Checker(){
        for(int i = 0; i < edges.size(); i++){
            if(edges.get(i).assumptionResultFunction.equals("fgv")){
                int sor = edges.get(i).startLine;
                if(!sorok.get(i).contains("__VERIFIER_nondet_")) return;
                //2 sor lett hozzá adva (--> nem ehhez van hozzáadva elv)
                int typeEleje = sorok.get(sor + 1).lastIndexOf("__VERIFIER_nondet_");

                Pattern pattern = Pattern.compile("__VERIFIER_nondet_" + "[a-z]+");
                Matcher matcher = pattern.matcher(sorok.get(sor - 1));
                matcher.find();
                int endidx = matcher.end();
                int startidx = matcher.start();
                String funcname = sorok.get(sor + 1).substring(startidx, endidx);
                edges.get(i).type = funcname.substring(("__VERIFIER_nondet_").length());
                if(edges.get(i).type.startsWith("u")) edges.get(i).type = "unsigned " + edges.get(i).type.substring(1);
                edges.get(i).assumptionResultFunction = funcname;

            }
        }
    }


    public static boolean CheckAtomic(int eleje){
        ArrayList<String> ujSorok = new ArrayList<>();
        boolean inAtomic = false;

        try {
            File myFile = new File(targetFolder + "/main.c");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                ujSorok.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba van a beolvasassal.");
            e.printStackTrace();
        }

        String adottSor = "";
        for (int i = eleje; i < ujSorok.size(); i++) {
            adottSor = ujSorok.get(i);
            if(adottSor.contains("__VERIFIER_atomic_end();")){
                inAtomic = false;
            }
            if(adottSor.contains("__VERIFIER_atomic_begin();")){
                inAtomic = true;
            }
            if(adottSor.contains("//generated") && inAtomic){
                System.out.println("atomic hiba");
                return false;
            }
        }
        return true;

    }

    /**
     * fordítás és futtatás
     */
    public static void CompileCprog() throws IOException {
        ClearAndSetFolder();
        //linuxra
        ProcessBuilder builder = new ProcessBuilder(
                "sh", "-c", "cd " + targetFolder + " && gcc -pthread main.c -o main &&  timeout 30s ./main");
        //windowsra
//        ProcessBuilder builder;
//        builder = new ProcessBuilder(
//                "cmd.exe", "/c", "cd " + targetFolder + " && gcc main.c -o main && main");
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String acc = "\noutput: \n";
        String line;
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null) { break; }
            System.out.println(line);
            acc = acc + line;
        }
        if(acc.contains("main") && (acc.contains("failed") || acc.contains("Aborted"))){
            System.out.println("failed, ok");
        }else if(acc.contains("Aborted (core dumped)")){
            System.out.println("failed, not ok");
        }else if(acc.contains("sikeres_pi")){
            System.out.println("sikeres_pi");
        }else {
            System.out.println("not failed, not ok");
        }
        try {
            FileWriter myWriter = new FileWriter(targetFolder + "/out.h");
            myWriter.write(acc);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Hiba van a kiiratassal.");
            e.printStackTrace();
        }
    }

    /**
     * Törli a mappa tartalmát és az elérési útvonalat módosítja
     * Azért lett kiszervezve, hogy a CompileProg() átláthatóbb legyen
     */
    public static void ClearAndSetFolder(){
        File dir = new File(targetFolder);

        String[] files = dir.list();
        if(files == null) return;
        if(files.length > 2){
            final File[] fileok = dir.listFiles();
            for (File f: fileok){
                if((!f.getName().equals("main.c")) && (!f.getName().equals("nondetfvek.h")) && (!f.getName().equals("out.txt")));
                    f.delete();
            }
        }

    }
}
