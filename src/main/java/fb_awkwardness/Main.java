package fb_awkwardness;

import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.max;
// Add any extra import statements you may need here


class Main {

    // Add any helper functions you may need here


    int minOverallAwkwardness(int[] arr) {
        // Write your code here

        //int[] arr_1 = {5, 10, 6, 8};
        //int[] arr_2 = {1, 2, 5, 3, 7}

        Arrays.sort(arr);

        int res[] = new int[arr.length];

        int l = 0;
        int r = arr.length - 1;
        boolean left = true;
        int i = 0;
        while (l <= r) {
            if (left) {
                res[l++] = arr[i++];
            } else {
                res[r--] = arr[i++];
            }
            left = !left;
        }

        int maxAwk = abs(res[0] - res[res.length - 1]);

        for (int j = 0; j < res.length - 1; j++) {
            maxAwk = max(maxAwk, abs(res[j] - res[j + 1]));
        }

        return maxAwk;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        int[] arr_1 = {5, 10, 6, 8};
        int expected_1 = 4;
        int output_1 = minOverallAwkwardness(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {1, 2, 5, 3, 7};
        int expected_2 = 4;
        int output_2 = minOverallAwkwardness(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new Main().run();
    }
}