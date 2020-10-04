package fb_matchingpairs;

// Add any extra import statements you may need here


import java.util.HashMap;
import java.util.Map;

public class MatchingPairs {
    int matchingPairs(String s, String t) {

        int l = 0;
        int r = 0;

        Map<Integer, Integer> charCountS = new HashMap<>();
        Map<Integer, Integer> charCountT = new HashMap<>();
        Map<Integer, Integer> equalCount = new HashMap<>();

        int bestMatch = 0;

        while (l < s.length() && r < s.length()) {
            char cs = s.charAt(r);
            char ct = t.charAt(r);
            if (cs != ct) {
                charCountS.compute(cs - 'a', (k, v) -> v == null ? 1 : v + 1);
                charCountT.compute(ct - 'a', (k, v) -> v == null ? 1 : v + 1);
            } else {
                equalCount.compute(cs - 'a', (k, v) -> v == null ? 1 : v + 1);
            }
            r++;
        }

        return bestMatch;
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
        {

            String s_1 = "abcde";
            String t_1 = "adcbe";
            int expected_1 = 5;
            int output_1 = matchingPairs(s_1, t_1);
            check(expected_1, output_1);
        }

        {

            String s_1 = "aaaaa";
            String t_1 = "aaaaa";
            int expected_1 = 5;
            int output_1 = matchingPairs(s_1, t_1);
            check(expected_1, output_1);
        }

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}