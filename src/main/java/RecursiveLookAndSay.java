/**
 * Created by darcio on 9/3/16.
 */
public class RecursiveLookAndSay {

    public static void main(String[] args) {
        String strBase7 = LookAndSay("11", 5);
        System.out.println(strBase7);
    }


    static String LookAndSay(String start, int n) {
        if (n == 0) {
            return start;
        } else {
            String intermediary = LookAndSayNotRecursive(start);
            return LookAndSay(intermediary, n - 1);
        }
    }

    private static String LookAndSayNotRecursive(String digits) {
        if (digits.isEmpty())
            return "";

        int d = 0;
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < digits.length(); i++)

            if (digits.charAt(d) != digits.charAt(i)) {

                final String digitsFound = digits.substring(d, i);
                sb.append(digitsFound.length()).append(digits.charAt(d));
                d = i;
            }

        return sb.
                append(digits.substring(d, digits.length()).length()).
                append(digits.charAt(d)).
                toString();
    }

}
