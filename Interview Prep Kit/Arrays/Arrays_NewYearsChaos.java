import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {

        //  ======== Tried this answer gave an error in the test case 2 ========

        /*
        if(q == null){return;}
        int bribes = 0;
        boolean poss = true;

        for(int i = 1; i < q.length+1; i++){
            int curr = q[i-1];
            if(i < curr){
                if(curr - i == 1){
                    bribes++;
                } else if(curr - i == 2){
                    bribes += 2;
                } else {
                    poss = false;
                }
                //System.out.println("Bribes = " + bribes);
                //System.out.println("Current = " +curr);
            }
        }

        if(!poss){
            System.out.println("Too chaotic");
        } else{
            System.out.println(bribes);
        }

        */

        //  ======== Attempt Dos ========

        if(q == null){return;}
        int bribes = 0;
        boolean pass = true;

        for(int i = 0; i < q.length; i++){
            if(q[i] - (i+1) > 2){
                pass = false;
                break;
            } else{
                for (int j = Math.max(0, q[i]-1-1); j < i; j++){
                    //System.out.println("j = " + q[j]);
                    //System.out.println("i = " + q[i]);

                    if (q[j] > q[i]) {
                        bribes++;
                      //  System.out.println(bribes);
                    }
                }
            }
        }

        if(!pass){
            System.out.println("Too chaotic");
        } else{
            System.out.println(bribes);
        }

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
