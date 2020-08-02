package maxwindowsubstring_fast;

class Solution {
    public static void main(String[] args) {

        System.out.println(new Solution().minWindow("bbaac", "baa"));
        /**
         System.out.println(new Solution().minWindow("a", "aa"));
         System.out.println(new Solution().minWindow("bba", "ab"));
         *
         System.out.println(new maxwindowsubstring.Solution().minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
         System.out.println(new Solution().minWindow("aa", "aa"));
         System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
         */

    }


    public String minWindow(String w, String t) {
        char[] wordChars = w.toCharArray();
        char[] templateChars = t.toCharArray();
        if (templateChars.length > wordChars.length) {
            return "";
        }
        int[] countByCharacter = new int[128];
        for (char c : templateChars) {
            countByCharacter[c]++;
        }
        int bestL = 0;
        int bestR = Integer.MAX_VALUE;
        int l = 0;
        int desiredStateZero = templateChars.length;

        for (int r = 0; r < wordChars.length; r++) {
            if (countByCharacter[wordChars[r]]-- > 0) {
                desiredStateZero--;
            }
            while (desiredStateZero == 0) {
                if (bestR - bestL > r - l) {
                    bestL = l;
                    bestR = r;
                }
                if (++countByCharacter[wordChars[l]] > 0) {
                    desiredStateZero++;
                }
                l++;
            }
        }
        return bestR == Integer.MAX_VALUE ? "" : w.substring(bestL, bestR + 1);
    }
}