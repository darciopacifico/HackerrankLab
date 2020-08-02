package longeststring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static final int COUNT_CHARS = 2;

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("ababacccccc") + " must be 7");
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("abc") + " must be 2");
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("eceba") + " must be 3");
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("ee") + " must be 2");
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("e") + " must be 1");
        System.out.println(new Solution().lengthOfLongestSubstringTwoDistinct("") + " must be 0");
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;

        int result = Integer.MIN_VALUE;
        Map<Character, Integer> lastPosPerChar = new HashMap<>();
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            if (lastPosPerChar.size() <= 2) {
                lastPosPerChar.put(s.charAt(end), end);
                end++;
            }

            if (lastPosPerChar.size() > 2) {
                int lastIndex = lastPosPerChar.get(s.charAt(start));
                if (start == lastIndex) {
                    lastPosPerChar.remove(s.charAt(start));
                }
                start++;
            }
            result = Math.max(result, end - start);
        }
        return result;
    }

}
