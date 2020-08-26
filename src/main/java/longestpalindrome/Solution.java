package longestpalindrome;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {

    public static final char SEP = '_';
    private boolean debug = true;

    public static void main(String[] args) {

        System.out.println(new Solution().longestPalindrome("aaaaaaaaa"));
        /*
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaa"));
        System.out.println(new Solution().longestPalindrome("cbcdcbedcbc"));
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("xbabcbaby"));
        System.out.println(new Solution().longestPalindrome("d"));

        String bigWord = "mwwfjysbkebpdjyabcfkgprtxpwvhglddhmvaprcvrnuxifcrjpdgnktvmggmguiiquibmtviwjsqwtchkqgxqwljouunurcdtoeygdqmijdympcamawnlzsxucbpqtuwkjfqnzvvvigifyvymfhtppqamlgjozvebygkxawcbwtouaankxsjrteeijpuzbsfsjwxejtfrancoekxgfyangvzjkdskhssdjvkvdskjtiybqgsmpxmghvvicmjxqtxdowkjhmlnfcpbtwvtmjhnzntxyfxyinmqzivxkwigkondghzmbioelmepgfttczskvqfejfiibxjcuyevvpawybcvvxtxycrfbcnpvkzryrqujqaqhoagdmofgdcbhvlwgwmsmhomknbanvntspvvhvccedzzngdywuccxrnzbtchisdwsrfdqpcwknwqvalczznilujdrlevncdsyuhnpmheukottewtkuzhookcsvctsqwwdvfjxifpfsqxpmpwospndozcdbfhselfdltmpujlnhfzjcgnbgprvopxklmlgrlbldzpnkhvhkybpgtzipzotrgzkdrqntnuaqyaplcybqyvidwcfcuxinchretgvfaepmgilbrtxgqoddzyjmmupkjqcypdpfhpkhitfegickfszermqhkwmffdizeoprmnlzbjcwfnqyvmhtdekmfhqwaftlyydirjnojbrieutjhymfpflsfemkqsoewbojwluqdckmzixwxufrdpqnwvwpbavosnvjqxqbosctttxvsbmqpnolfmapywtpfaotzmyjwnd";
        long now = System.currentTimeMillis();
        System.out.println(new Solution().longestPalindrome(bigWord));
        System.out.println((System.currentTimeMillis() - now));
        */

    }


    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        String oddString;
        oddString = getOddString(s);

        String oddPalindrome = longestOddPalindrome(oddString);

        String normalizeResponse;
        normalizeResponse = normalizeResponse(oddPalindrome);

        return normalizeResponse;
    }

    private String getOddString(String s) {
        char[] oddChars = new char[(s.length() * 2) + 1];
        oddChars[0] = SEP;
        int i;
        for (i = 0; i < s.length(); i++) {
            oddChars[(i * 2) + 1] = s.charAt(i);
            int i1 = (i * 2) + 2;
            oddChars[i1] = SEP;
        }

        return new String(oddChars);
    }

    private String normalizeResponse(String oddPalindrome) {

        StringBuilder stringBuilder = new StringBuilder(oddPalindrome.length() / 2);


        char[] c = oddPalindrome.toCharArray();

        for (int i = 0; i < c.length; i++) {

            char c1 = c[i];
            if (c1 != SEP) {
                stringBuilder.append(c1);
            }
        }


        String s = stringBuilder.toString();
        return s;
    }

    private String longestOddPalindrome(String s) {
        int l = 0;
        int r = 0;
        int c = 0;

        int bestC = 0;
        int bestE = 0;

        int p[] = new int[s.length()];

        for (int i = 1; i < s.length(); ) {
            if (i < c + p[c]) {
                int centerDistance = i - c;
                int opposite = c - centerDistance;
                int savedChecks = p[opposite];
                p[i] = min(((c + p[c]) - i), savedChecks);
            }

            int e = p[i];

            while (i - e >= 0 && i + e < s.length()) {

                if (s.charAt(i - e) == s.charAt(i + e)) {

                    if (e >= bestE) {
                        bestE = e;
                        bestC = i;
                    }

                    p[i] = e++;

                    if (i > (c + p[c])) {
                        c = i;

                        if (debug)
                            System.out.println(c);
                    }

                } else {
                    break;
                }
            }



            i = max(i + 1, i + (e / 4));
            //i++;
            //e = p[i];

        }

        if (debug) {

            System.out.println();
            System.out.println();
            for (int i = 0; i < p.length; i++) {
                System.out.print(i / 10);
            }
            System.out.println();
            for (int i = 0; i < p.length; i++) {
                System.out.print(i % 10);
            }
            System.out.println();
            for (int i = 0; i < s.length(); i++) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
            for (int i = 0; i < p.length; i++) {
                System.out.print(p[i] / 10);
            }
            System.out.println();
            for (int i = 0; i < p.length; i++) {
                System.out.print(p[i] % 10);
            }
            System.out.println();
            System.out.println("bestC " + bestC);
            System.out.println("bestE " + bestE);
            System.out.println();


        }
        l = bestC - bestE;
        r = bestC + bestE;


        return s.substring(l, r);
    }

}
