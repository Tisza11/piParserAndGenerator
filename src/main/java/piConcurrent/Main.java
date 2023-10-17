package piConcurrent;

import org.xml.sax.SAXException;
import parser.Parse;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    //majd  @Parameter -nek ki kell szervezni, de amíg építem, addig marad így
    //C file neve
    public static String codeFile;

    //élek adatainak eltárolása beolvasás után ebben
    static ArrayList<Edge> edges = new ArrayList<>();

    //élek listájának fenntartása ahhoz, hogy rendezve legyenek fv szerint
    public static ArrayList<Edge> edgesForInit = new ArrayList<>();

    //fv-ek tárolása (név, kezdő sor, utolsó sor)
    public static ArrayList<Fun> funok = new ArrayList<>();

    //majd  @Parameter -nek ki kell szervezni, de amíg építem, addig marad így
    //witness file elérési útja
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
    public static String sourceFolder;

    //ebben vannak eltárolva azok az élek, amelyeken meg van adva threadID
    public static ArrayList<Edge> szalelek = new ArrayList<>();

//    //a jelenlegi szálat tárolja    //jelenleg nincs használva
//    public static int CurrentThread = 0;

    //majd  @Parameter -nek ki kell szervezni, de amíg építem, addig marad így
    //cél mappa elérési útja
    public static String targetFolder = "futasra";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        sourceFolder = "C:\\egyetem masolat\\felev6\\Onlab\\c-probak\\";
        gmlFile = "witnessAzonos.graphml"; //"rwl2.graphml";
        codeFile = "funok.i"; //"read_write_lock-2.i";
        targetFolder = "C:\\egyetem masolat\\felev6\\Onlab\\futasra\\";
        if(!ReadXML.Read_XML(gmlFile, codeFile)) return;
        System.out.println("Read xml done");
        InIt.Init();
        System.out.println("Init done");
        ReadCode(/*codeFolder, */codeFile);
        System.out.println("Read code done");
        ReadFuns();
        System.out.println("Read funs done");
        Checker();
        System.out.println("Checker done");
        WriteCode.Write_Code();
        System.out.println("Write code done");
        CompileCprog();
        System.out.println("Compile and run done");
    }


    /**
     * beolvasásra kerül a c/i file tartalma
     * @param codeFile ez a code file kerül beolvasásra
     */
    public static void ReadCode(/*String codeFolder, */String codeFile){
        try {
            File myFile = new File(sourceFolder + codeFile);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //akor kell, ha a saját windows-os gépemen akarom futtatni, library gondok miatt
                sorok.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Hiba van a beolvasassal.");
            e.printStackTrace();
        }
        /*int lastvmi = data.lastIndexOf('{');
        int lastassertf = data.lastIndexOf("__assert_fail");
        String seged1 = "";
        if(lastvmi > -1 && lastassertf > -1){
            seged1  = data.substring(lastvmi, lastassertf + ("__assert_fail").length());
        }
        if(data.contains(seged1) && lastvmi > -1 && lastassertf > -1){
            String val = data.substring(0,lastvmi + 1) + "_assert" + data.substring(lastassertf + ("__assert_fail").length());
            data = val;

            int lastComa = data.lastIndexOf(',');
            int lastBracket = data.lastIndexOf(')');
            String val1 = data.substring(0,lastComa) + data.substring(lastBracket);
            data = val1;
            //System.out.println(data + "\n");
        }*/
    }

    /**
     * Megkeresi a használt fv-ek neveit, első és utolsó sorait
     */
    public static void ReadFuns() {
//        Pattern pattern;
//        Matcher matcher;
//        int i = 1833;
//        int counter = 1;
//        pattern = Pattern.compile(".*\\*.*\\(.*\\).*\\{.*");
//        while (i < sorok.size()) {
//            matcher = pattern.matcher(sorok.get(i));
//            if (matcher.find() || sorok.get(i).contains("main")) {
//                Fun fun = new Fun();
//                if(sorok.get(i).contains("main")) fun.name = "main";
//                else fun.name = sorok.get(i).substring(sorok.get(i).indexOf('*'), sorok.get(i).indexOf('('));
//                if(fun.name.contains(" ")) fun.name = fun.name.trim();
//                fun.startLine = i;
//                while(counter > 0){
//                    i++;
//                    if(sorok.get(i).contains("{") || sorok.get(i).contains("}")){
//                        for(int j = 0; j < sorok.get(i).length(); j++){
//                            if(sorok.get(i).charAt(j) == '{') counter++;
//                            if(sorok.get(i).charAt(j) == '}') counter--;
//                        }
//                    }
//                }
//                fun.endLine = i;
//                funok.add(fun);
//                counter = 1;
//            }
//            i++;
//        }
        System.out.println(sourceFolder + codeFile);
        Parse.parse(sourceFolder + codeFile); // itt probalom ki az antlr mukodeset a projektben
        for (int i = 0; i < funok.size(); i++) {
            System.out.println(funok.get(i).name);
            System.out.println(funok.get(i).startLine);
            System.out.println(funok.get(i).endLine);
        }
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


    /**
     * fordítás és futtatás
     */
    public static void CompileCprog() throws IOException {
        ClearAndSetFolder();
        //linuxra
//        ProcessBuilder builder = new ProcessBuilder(
//                "sh", "-c", "cd " + targetFolder + " && gcc main.c -o main && ./main");
        ProcessBuilder builder;
        builder = new ProcessBuilder(
                "cmd.exe", "/c", "cd " + targetFolder + " && gcc main.c -o main && main");
//        builder.directory(new File("/futasra/"));
        //windowsra
//        Process compile = new ProcessBuilder(
//                "cmd", "/C", "gcc" + "\"" + targetFolder + "-o", targetFolder + "main.exe", targetFolder + "main.c").start();
//        ProcessBuilder builder = new ProcessBuilder(
//                "cd", targetFolder, "&&", "./main.exe");
        builder.redirectErrorStream(true);
        Process p = null;
        try {
            p = builder.start();
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            try {
                line = r.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (line == null) { break; }
            System.out.println(line);
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
                if((!f.getName().equals("main.c")) && (!f.getName().equals("nondetfvek.h")));
                    f.delete();
            }
        }

    }
}
