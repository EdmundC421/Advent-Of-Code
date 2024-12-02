import java.io.*;
import java.util.*;

public class Day01 {
    public static void main(String[] args) {
        try {
            FileReader filereader = new FileReader("problem1.txt");
            int s;
            String acc = "";
            while ((s = filereader.read()) != -1) {
                acc += (char) s;
            }
            String[] str = acc.split("\\s+");
            ArrayList<String> first = new ArrayList<>();
            ArrayList<String> second = new ArrayList<>();
            for (int i = 0; i < str.length; i++) {
                if (i % 2 == 0) {
                    first.add(str[i]);
                } else {
                    second.add(str[i]);
                }
            }
            Collections.sort(first);
            Collections.sort(second);
            // int total = 0;
            // System.out.println("Size: " + first.size());
            // for (int i = 0; i < first.size(); i++) {
            //     total += Math.abs(Integer.parseInt(first.get(i)) - Integer.parseInt(second.get(i)));
            // }
            // System.out.println(total);
            int[] similar = new int[first.size()];
            int n = 0;
            for(int i = 0; i < first.size(); i++){
                for(int j = 0; j < second.size(); j++){
                    if(Integer.parseInt(first.get(i)) == Integer.parseInt(second.get(j))){
                        n++;
                    }
                }
                similar[i] = Integer.parseInt(first.get(i)) * n;
                n = 0;
            }
            int m = 0;
            for(int i =0; i < similar.length; i++){
                m += similar[i];
            }
            System.out.println("Similar: " + m);
            filereader.close();
        } catch (Exception e) {
            System.out.println("excpetion: " + e);
        }
    }
}