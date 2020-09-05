package fb_sumpairs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// Add any extra import statements you may need here


class PairSums {
    // Add any helper functions you may need here
    int numberOfWays(int[] arr, int k) {
        Map<Integer, Integer> indexesByNumber = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            if (!indexesByNumber.containsKey(number)) {
                indexesByNumber.put(number, 1);
            } else {
                int count = indexesByNumber.get(number);
                indexesByNumber.put(number, count + 1);
            }
        }

        int count = 0;
        Set<Integer> integers = new HashSet<>();

        integers.addAll(indexesByNumber.keySet());
        for (int number : integers) {

            int otherNumber = k - number;
            Integer countOfNumber = indexesByNumber.get(otherNumber);
            if (countOfNumber == null) continue;

            if (number == otherNumber) {
                count += (countOfNumber * (countOfNumber - 1)) / 2;
            } else {
                indexesByNumber.remove(number);
                count += countOfNumber;
            }
        }
        // 10:48 started
        // 11:22 finished - first green: O(N) TBC
        // 11:29 optimizes to use just a count
        return count;
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
        int k_1 = 6;
        int[] arr_1 = {1, 2, 3, 4, 3};
        int expected_1 = 2;
        int output_1 = numberOfWays(arr_1, k_1);
        check(expected_1, output_1);

        int k_2 = 6;
        int[] arr_2 = {1, 5, 3, 3, 3};
        int expected_2 = 4;
        int output_2 = numberOfWays(arr_2, k_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new PairSums().run();
    }
}