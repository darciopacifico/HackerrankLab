package longestsubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwwke"));
        System.out.println(new Solution().lengthOfLongestSubstring("a"));
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        int beginning = -1;
        int maxSize = 0;
        Map<Character, Integer> charPositionMap = new HashMap<>();
        for (int charPosition = 0; charPosition < s.length(); charPosition++) {
            char c = s.charAt(charPosition);

            if (charPositionMap.containsKey(c)) {
                beginning = Math.max(beginning, charPositionMap.get(c));
            }

            charPositionMap.put(c, charPosition);
            int tamAtual = charPosition - beginning;
            maxSize = Math.max(maxSize, tamAtual);
        }
        return maxSize;
    }

}