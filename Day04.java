import java.io.FileReader;
import java.util.ArrayList;

public class Day04 {
    public static void main(String[] args) {
        try{
            FileReader filereader = new FileReader("problem4.txt");
            int s;
            String acc = "";
            while ((s = filereader.read()) != -1) {
                acc += (char) s;
            }
            String[] ar = acc.split("\\r?\\n|\\r");
            String[][] arr = new String[140][]; 
            for(int i = 0; i < 140; i++){
                arr[i] = ar[i].split("");
            }
            for(int i = 0; i < 140; i++){
                for(int j = 0; j < 140; j++){
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }
            int xmas = 0;
            /* 
             * left
             * right
             * up
             * down
             * diagonal up left
             * diagonal down left
             * diagonal up right
             * diagonal down right
             */
            int right = 0;
            int left = 0;
            int up = 0;
            int down = 0;
            int rightUp = 0;
            int rightDown = 0;
            int leftUp = 0;
            int leftDown = 0;
            String letter = "";
            System.out.println("y = " + arr.length);
            System.out.println("x = " + arr[0].length);
            int count = 0;
            // for(int y = 0; y < arr.length; y++){
            //     for(int x = 0; x < arr[0].length; x++){
            //         letter = arr[y][x];
            //         if(letter.equals("X")){
            //             count++;
            //             if(x < arr[0].length-3){ //right
            //                 if(arr[y][x+1].equals("M") && arr[y][x+2].equals("A") && arr[y][x+3].equals("S")){
            //                     xmas++;
            //                     right++;
            //                 }
            //             }
            //             if(x > 2){ //left
            //                 if(arr[y][x-1].equals("M") && arr[y][x-2].equals("A") && arr[y][x-3].equals("S")){
            //                     xmas++;
            //                     left++;
            //                 }
            //             }
            //             if(y < arr.length-3){  //down
            //                 if(arr[y+1][x].equals("M") && arr[y+2][x].equals("A") && arr[y+3][x].equals("S")){
            //                     xmas++;
            //                     down++;
            //                 }
            //             }
            //             if(y > 2){ //up
            //                 if(arr[y-1][x].equals("M") && arr[y-2][x].equals("A") && arr[y-3][x].equals("S")){
            //                     xmas++;
            //                     up++;
            //                 }
            //             }
            //             if(x < arr[0].length-3 && y < arr.length-3){ //right down
            //                 if(arr[y+1][x+1].equals("M") && arr[y+2][x+2].equals("A") && arr[y+3][x+3].equals("S")) {
            //                     xmas++;
            //                     rightDown++;
            //                 }
            //             }
            //             if(x < arr[0].length-3 && y > 2){ //right up
            //                 if(arr[y-1][x+1].equals("M") && arr[y-2][x+2].equals("A") && arr[y-3][x+3].equals("S")){
            //                     xmas++;
            //                     rightUp++;
            //                 }
            //             }
            //             if(x > 2 && y < arr.length-3){ //left down
            //                 if(arr[y+1][x-1].equals("M") && arr[y+2][x-2].equals("A") && arr[y+3][x-3].equals("S")){
            //                     xmas++;
            //                     leftDown++;
            //                 }
            //             }
            //             if(x > 2 && y > 2){ //left up
            //                 if(arr[y-1][x-1].equals("M") && arr[y-2][x-2].equals("A") && arr[y-3][x-3].equals("S")){
            //                     xmas++;
            //                     leftUp++;
            //                 }
            //             }
            //         }
            //     }
            // }
            for(int i = 0; i < 138; i++){
                for(int j = 0; j < 138; j++){
                    if(isMas(arr[i][j+2], arr[i][j], arr[i+1][j+1], arr[i+2][j], arr[i+2][j+2])) xmas++;
                }
            }
            System.out.println("XMAS: " + xmas);
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }   
    public static boolean isMas(String topRight, String topLeft, String middle, String bottomLeft, String bottomRight){
        return ((topLeft.equals("M") && topRight.equals("M") && middle.equals("A") && bottomLeft.equals("S") && bottomRight.equals("S"))
        ||      (topLeft.equals("M") && topRight.equals("S") && middle.equals("A") && bottomLeft.equals("M") && bottomRight.equals("S"))
        ||      (topLeft.equals("S") && topRight.equals("S") && middle.equals("A") && bottomLeft.equals("M") && bottomRight.equals("M"))
        ||      (topLeft.equals("S") && topRight.equals("M") && middle.equals("A") && bottomLeft.equals("S") && bottomRight.equals("M")));
    }
}
