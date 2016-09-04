import java.util.Arrays;

/**
 * Created by darcio on 8/29/16.
 */
public class DigitIncrementer {

    public static void main(String[] args) {
        int[] iDigs = iDigs = getArrDigs(0);

        for (int i = 0; i <= 1000 * 1000; i++) {
            iDigs = increment(iDigs);
            int[] check = getArrDigs(i+1);

            if (!checkEq(iDigs, check)) {
                throw new RuntimeException("dig incremente goes wrong!");
            }
        }

        System.out.println("Success!!");

    }

    private static boolean checkEq(int[] iDigs, int[] check) {

        if (iDigs.length != check.length) return false;

        for (int i = 0; i < iDigs.length; i++)
            if (iDigs[i] != check[i]) return false;

        return true;
    }

    private static int[] getArrDigs(int i) {
        String strI = i + "";

        char[] cDigs = strI.toCharArray();
        int[] iDigs = new int[cDigs.length];

        for (int y = 0; y < cDigs.length; y++)
            iDigs[y] = (cDigs[y]-48);
        return iDigs;
    }


    public static int[] increment(int[] digits) {

        int inc = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + inc == 10) {
                digits[i] = 0;
                inc = 1;
            } else {
                digits[i]++;
                inc = 0;
                break;
            }
        }


        if (inc == 1) {
            int[] newDig = Arrays.copyOf(digits, digits.length + 1);

            newDig[0] = inc;

            digits = newDig;
        }


        return digits;
    }


}
