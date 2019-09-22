package coinchange;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the getWays function below.
    static long getWays(long n, long[] c) {


        HashMap<Long, Map<Integer, Long>> memo = new HashMap<>();

        long count = count(0, c, n, memo);

        return count;
    }

    public static long count(int i, long[] coins, long change, Map<Long, Map<Integer, Long>> memo) {

        // if total is 0, return 1
        if (change == 0) {
            return 1;
        }

        // return 0 if total become negative
        if (change < 0 || i >= coins.length) {
            return 0;
        }

        Map<Integer, Long> integerLongMap1 = memo.get(change);
        if (integerLongMap1 != null && integerLongMap1.containsKey(i)) {
            return integerLongMap1.get(i);
        }

        long l = count(i, coins, change - coins[i], memo) +
                count(i + 1, coins, change, memo);

        if (!memo.containsKey(change)) {
            memo.put(change, new HashMap<>());
        }

        Map<Integer, Long> integerLongMap = memo.get(change);
        if (!integerLongMap.containsKey(i)) {
            integerLongMap.put(i, l);
        }

        return l;

    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        String output_path = System.getenv("OUTPUT_PATH");
        if (output_path == null) {
            long ways = getWays(1000, new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19});
            System.out.println(ways);

            ways = getWays(4, new long[]{1, 2, 3});
            System.out.println(ways);

            return;
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output_path));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        long[] c = new long[m];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long cItem = Long.parseLong(cItems[i]);
            c[i] = cItem;
        }

        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'

        long ways = getWays(n, c);

        bufferedWriter.write("" + ways);

        bufferedWriter.close();

        scanner.close();
    }
}