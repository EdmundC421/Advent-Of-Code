import java.io.FileReader;

public class Day03 {
    public static void main(String[] args) {
        try{
            FileReader filereader = new FileReader("problem3.txt");
            int s;
            String acc = "";
            while ((s = filereader.read()) != -1) {
                acc += (char) s;
            }
            int index;
            String test = "";
            int accum = 0;
            String[] parts = new String[2];
            index = acc.indexOf("mul(");
            int count = 0;
            int err = 0;
            int space = 0;

            int doo = 0;
            int dont = 0;
            doo = acc.indexOf("do()");
            dont = acc.indexOf("don't()");
            
            boolean en = true;

            while (index != -1) {
                // System.out.println("["+ count++ + "]");
                // System.out.println(index);
                
                if(doo < index && doo < dont && doo != -1 && dont != -1){
                    en = true;
                    acc = acc.substring(doo +4);
                }else if(dont < doo && dont < index && doo != -1 && dont != -1){
                    en = false;
                    acc = acc.substring(dont +7);
                }else if(dont ==-1 && doo == -1){
                    acc = acc.substring(index);
                    // System.out.println("Do:" + doo);
                    // System.out.println("Dont:" + dont);
                    // System.out.println("index: " + index);
                    System.out.println("[" + count++ + "]: " + acc);
                    test = acc.substring(4, acc.indexOf(")"));
                    parts = test.split(",");
                    if(parts.length == 2){
                        try{
                            if(parts[0].contains(" ") || parts[0].contains(" ")){
                                space++;
                            }else{
                                if(en) accum += Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
                            }
                        }catch(Exception e){
                            err++;
                        }
                    }
                    acc = acc.substring(4);
                }else if(doo == -1){
                    if(dont < index){
                        en = false;
                        acc = acc.substring(dont +7);
                    }else{
                        acc = acc.substring(index);
                    // System.out.println("Do:" + doo);
                    // System.out.println("Dont:" + dont);
                    // System.out.println("index: " + index);
                    System.out.println("[" + count++ + "]: " + acc);
                    test = acc.substring(4, acc.indexOf(")"));
                    parts = test.split(",");
                    if(parts.length == 2){
                        try{
                            if(parts[0].contains(" ") || parts[0].contains(" ")){
                                space++;
                            }else{
                                if(en) accum += Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
                            }
                        }catch(Exception e){
                            err++;
                        }
                    }
                    acc = acc.substring(4);
                    }
                }else if (dont == -1){
                    if(doo < index){
                        en = true;
                        acc = acc.substring(dont +7);
                    }else{
                        acc = acc.substring(index);
                    // System.out.println("Do:" + doo);
                    // System.out.println("Dont:" + dont);
                    // System.out.println("index: " + index);
                    System.out.println("[" + count++ + "]: " + acc);
                    test = acc.substring(4, acc.indexOf(")"));
                    parts = test.split(",");
                    if(parts.length == 2){
                        try{
                            if(parts[0].contains(" ") || parts[0].contains(" ")){
                                space++;
                            }else{
                                if(en) accum += Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
                            }
                        }catch(Exception e){
                            err++;
                        }
                    }
                    acc = acc.substring(4);
                    }
                }
                else if (index < doo && index < dont && doo != -1 && dont != -1){
                    acc = acc.substring(index);
                    // System.out.println("Do:" + doo);
                    // System.out.println("Dont:" + dont);
                    // System.out.println("index: " + index);
                    System.out.println("[" + count++ + "]: " + acc);
                    test = acc.substring(4, acc.indexOf(")"));
                    parts = test.split(",");
                    if(parts.length == 2){
                        try{
                            if(parts[0].contains(" ") || parts[0].contains(" ")){
                                space++;
                            }else{
                                if(en) accum += Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]);
                            }
                        }catch(Exception e){
                            err++;
                        }
                    }
                    acc = acc.substring(4);
                }
                // System.out.println("[" + (count -.5) + "]: " + acc);
                index = acc.indexOf("mul(");
                doo = acc.indexOf("do()");
                dont = acc.indexOf("don't()");
                System.out.println("Do:" + doo);
                    System.out.println("Dont:" + dont);
                    System.out.println("index: " + index);
                // System.out.println("Next: " + index);
            }
            System.out.println("space : " + space);
            System.out.println("err: " + err);
            System.out.println("accum: " + accum);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }
}
