package maxwindowsubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static final char A = 'a';

    public static void main(String[] args) {

        System.out.println(new Solution().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd").equals("abbbbbcdd"));
        System.out.println(new Solution().minWindow("bbaac", "baa").equals("baa"));
        System.out.println(new Solution().minWindow("aa", "aa").equals("aa"));
        System.out.println(new Solution().minWindow("a", "aa").equals(""));
        System.out.println(new Solution().minWindow("bba", "ab").equals("ba"));
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC").equals("BANC"));
        /*
         */

    }


    public String minWindow(String word, String template) {

        int[] countByChar = new int[200];
        Map<Character, Integer> charSet = new HashMap<>();

        int l = 0;
        int bestL = 0;
        int bestR = 0;

        int desiredStateZero = 0;

        for (char c : template.toCharArray()) {
            countByChar[c]++;
            desiredStateZero++;
        }

        for (int r = 0; r < word.length(); r++) {

            if (desiredStateZero > 0) {

                char c = word.charAt(r);
                if (countByChar[c]-- > 0) {
                    desiredStateZero--;
                }

            } else {

                while (desiredStateZero == 0) {
                    if ((r - l) < (bestR - bestL)) {
                        bestL = l;
                        bestR = r;
                    }
                    char c = word.charAt(l);
                    if (++countByChar[c] > 0) {
                        desiredStateZero++;
                    }

                    l++;
                }
            }


        }

        return word.substring(bestL, bestR);
    }

    private boolean possiblyValid(Map<Character, Integer> charSet, Map<Character, Integer> countByChar) {
        if (charSet.keySet().size() != countByChar.keySet().size()) {
            return false;
        }

        for (Character c : countByChar.keySet()) {
            if (countByChar.get(c) < charSet.get(c)) {
                return false; // it doesn't have enough c's
            }
        }

        return true;
    }

    private boolean dragR(Map<Character, Integer> charSet, Map<Character, Integer> countByChar, String word, int r) {
        if (r >= word.length()) return false;

        if (countByChar.keySet().size() < charSet.keySet().size()) return true; // there are less chars than we expect

        for (Character c : countByChar.keySet()) {

            if (countByChar.get(c) < charSet.get(c)) {
                return true; // it doesn't have enough c's
            }
        }

        return false;
    }


}
