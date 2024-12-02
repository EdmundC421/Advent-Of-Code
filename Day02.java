import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Day02 {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try{
            FileReader filereader = new FileReader("problem2.txt");
            int s;
            String acc = "";
            while ((s = filereader.read()) != -1) {
                acc += (char) s;
            }
            String[] str = acc.split("\\r?\\n|\\r");
            ArrayList<String[]> arr = new ArrayList<>();
            for(String string: str){
                arr.add(string.split("\s"));
            }
            int safe = 0;
            boolean b = true;
            boolean m = false;
            String[] report;
            // for(int i = 0; i < arr.size(); i++){
            //     System.out.print("[" + i + "]: ");
            //     report = arr.get(i);
            //     for(int j = 0; j < arr.get(i).length; j++){
            //         System.out.print(report[j] + " ");
            //     }
            //     System.out.println();
            // }
            int inc = 0;
            int dec = 0;
            int zero = 0;
            // for(int i = 0; i < arr.size(); i++){
            //     report = arr.get(i);
            //     if(Integer.parseInt(report[0]) > Integer.parseInt(report[1])){
            //         dec++;
            //         for(int j = 0; j < report.length-1; j++){
            //             b = b && (Integer.parseInt(report[j]) - Integer.parseInt(report[j + 1]) >= 1 &&
            //                       Integer.parseInt(report[j]) - Integer.parseInt(report[j + 1]) <= 3);
            //         }
            //     }else if(Integer.parseInt(report[0]) < Integer.parseInt(report[1])){
            //         inc++;
            //         for(int j = 0; j < report.length-1; j++){
            //             b = b && (Integer.parseInt(report[j+1]) - Integer.parseInt(report[j]) >= 1 &&
            //                       Integer.parseInt(report[j+1]) - Integer.parseInt(report[j]) <= 3);
            //         }
            //     }else if(Integer.parseInt(report[0]) == Integer.parseInt(report[1])){
            //         zero++;
            //         b = false;
            //     }
            //     if(b){
            //         safe++;
            //     }
            //     b = true;
            // }
            ArrayList<String>[] permute;
             for(int i = 0; i < arr.size(); i++){
                report = arr.get(i);
                permute = new ArrayList[report.length];
                for(int a = 0; a < report.length; a++){
                    permute[a] = new ArrayList<String>();
                    for(int c = 0; c < report.length; c++){
                        if(c != a){
                            permute[a].add(report[c]);
                        }
                    }
                }
                // System.out.println("Report[" + i + "]------------------------------------------------------------------------------------------------");
                // for(int a = 0; a < report.length; a++){
                //     System.out.println("Permutation[" + a +"]: ------------------------------------------------");
                //     for(int c = 0; c < permute[a].size(); c++){
                //         System.out.print(permute[a].get(c) + " ");
                //     }
                //     System.out.println();
                // }
                for(ArrayList<String> a: permute){
                    if(Integer.parseInt(a.get(0)) > Integer.parseInt(a.get(1))){
                        dec++;
                        for(int j = 0; j < a.size() -1; j++){
                            b = b && (Integer.parseInt(a.get(j)) - Integer.parseInt(a.get(j+1)) >= 1 &&
                                      Integer.parseInt(a.get(j)) - Integer.parseInt(a.get(j+1)) <= 3);
                        }
                    }else if(Integer.parseInt(a.get(0)) < Integer.parseInt(a.get(1))){
                        inc++;
                        for(int j = 0; j < a.size()-1; j++){
                            b = b && (Integer.parseInt(a.get(j+1)) - Integer.parseInt(a.get(j)) >= 1 &&
                                      Integer.parseInt(a.get(j+1)) - Integer.parseInt(a.get(j)) <= 3);
                        }
                    }else if(Integer.parseInt(a.get(0)) == Integer.parseInt(a.get(1))){
                        zero++;
                        b = false;
                    }
                    // System.out.println(b);
                    m = m || b;
                    b = true;
                }
                // System.out.println("---------------------------------");
                if(m){
                    safe++;
                }
                b = true;
                m = false;
            }
            System.out.println("inc: " + inc);
            System.out.println("dec: " + dec);
            System.out.println("zero: " + zero);
            System.out.println("Safe Reports: " + safe);
            filereader.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
