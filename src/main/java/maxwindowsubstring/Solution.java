package maxwindowsubstring;


import static java.lang.Integer.MAX_VALUE;

public class Solution {

    public static final char A = 'a';

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("aa", "aa"));
        System.out.println(new Solution().minWindow("bba", "ab"));
        System.out.println(new Solution().minWindow("bbaac", "baa"));
        System.out.println(new Solution().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        System.out.println(new Solution().minWindow("a", "aa"));
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        /*
         */
    }

    public String minWindow(String word, String template) {
        final int letters = 'z' - 'A' + 1;

        final char[] wordChars = word.toCharArray();
        final int[] templateMap = new int[letters];

        final int[] countMap = new int[letters];

        int countKey = template.length();
        for (char c : template.toCharArray()) {
            templateMap[c - 'A']++;
        }

        int bestR = MAX_VALUE;
        int bestL = 0;

        int l = 0;

        final int maxL = wordChars.length - template.length();

        for (int r = 0; r < wordChars.length; r++) {
            char c = wordChars[r];
            if (++countMap[c - 'A'] <= templateMap[c - 'A']) {
                countKey--;
                while (countKey == 0 && l <= maxL) {
                    if (r - l < bestR - bestL) {
                        bestL = l;
                        bestR = r + 1;
                    }

                    char cL = wordChars[l];
                    countMap[cL - 'A']--;
                    if (countMap[cL - 'A'] < templateMap[cL - 'A']) {
                        countKey++;
                    }

                    l++;
                }
            }
        }

        if (bestR == MAX_VALUE) { // the word var doesn't even contain all chars from the template
            return "";
        }

        return word.substring(bestL, bestR);
    }


}
