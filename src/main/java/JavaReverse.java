/**
 * Created by darcio on 8/19/16.
 */
public class JavaReverse {

    public static void main(String[] args) {

        System.out.println(JavaReverse.reverseStr("darcio"));
        System.out.println(JavaReverse.reverseStr("111123333"));
        System.out.println(JavaReverse.reverseStr("11113333"));
        System.out.println(JavaReverse.reverseStr("Alice sends a message to Bob").
                equals("boB ot egassem a sdnes ecilA"));
    }


    /**
     * returns the reverse of string
     * @param str origina
     *            l string
     * @return reverse string
     */
    public static String reverseStr(String str) {
        if (str == null)
            throw new NullPointerException();

        char[] strChar = str.toCharArray();

        for (int i = 0; i < strChar.length / 2; i++) {
            int oposite = strChar.length - 1 - i;
            char c = strChar[i];
            strChar[i] = strChar[oposite];
            strChar[oposite] = c;
        }

        return new String(strChar);
    }

}
