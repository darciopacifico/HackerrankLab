package plusone;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        tryDigit(new int[]{9, 9, 9});

        tryDigit(new int[]{1, 2, 9});
        tryDigit(new int[]{1, 2, 3});
    }

    private static void tryDigit(int[] digits) {
        System.out.println(
                Arrays.toString(digits) + " + 1 = " + Arrays.toString(new Solution().plusOne(digits))
        );
    }

    public int[] plusOne(int[] digits) {


        return plusOne(digits, digits.length - 1);

    }

    private int[] plusOne(final int[] digits, final int i) {

        if (i < 0) {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }


        if (digits[i] + 1 == 10) {
            digits[i] = 0;
            return plusOne(digits, i - 1);
        } else {
            digits[i]++;
        }

        return digits;
    }

}
