package commonchild;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String output_path = System.getenv("OUTPUT_PATH");

        String s1;
        String s2;
        int result;
        if (output_path == null) {

            s1 = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVH";
            s2 = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUY";

            //s1 = "WEWOUCUIDW";
            //s2 = "FDAGCXGKCW";

            long now3 = System.nanoTime();
            result = lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
            System.out.print("chars: result " + result + " time: " + (System.nanoTime() - now3));
           /*
            for (int i = 5; i < s1.length(); i++) {
                String ss1 = s1.substring(0, i);
                String ss2 = s2.substring(0, i);

                long now1 = System.nanoTime();
                result = lcs(ss1.toCharArray(), ss2.toCharArray(), ss1.length(), ss2.length());
                System.out.print("chars: " + i + " result " + result + " time: " + (System.nanoTime() - now1));

                long now2 = System.nanoTime();
                int result2 = lcs2(ss1.toCharArray(), ss2.toCharArray(), ss1.length(), ss2.length());
                System.out.println(" chars: " + i + " result2: " + result2 + " time: " + (System.nanoTime() - now2));
            }*/

        } else {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output_path));
            s1 = scanner.nextLine();
            s2 = scanner.nextLine();
            result = lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
            bufferedWriter.close();
        }


        scanner.close();
    }


    static int lcs(char[] X, char[] Y, int m, int n) {

        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                memo[i][j] = -1;
            }
        }

        return lcs(X, Y, m, n, memo);
    }

    static int lcs(char[] X, char[] Y, int m, int n, int[][] memo) {

        if (m > 0 && n > 0 && memo[m - 1][n - 1] > -1) {

            System.out.println(" saving  m:" + (m - 1) + " n:" + (n - 1));

            return memo[m - 1][n - 1];
        }

        int result;
        if (m == 0 || n == 0) {
            result = 0;
        } else if (X[m - 1] == Y[n - 1]) {
            result = 1 + lcs(X, Y, m - 1, n - 1, memo);
        } else {
            result = Math.max(lcs(X, Y, m, n - 1, memo), lcs(X, Y, m - 1, n, memo));
        }

        if (m > 0 && n > 0)
            memo[m - 1][n - 1] = result;

        return result;
    }


    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    static int lcs2(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

}