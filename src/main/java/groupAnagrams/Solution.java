package groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(

                new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})
        );
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word: strs) {

            String wordKey = getKey(word);

            if(!anagramMap.containsKey(wordKey)){
                anagramMap.put(wordKey, new ArrayList());
            }

            anagramMap.get(wordKey).add(word);
        }

        return new ArrayList<>(anagramMap.values());
    }

    private String getKey(String word) {

        int[] charCount = new int[26];

        for (int i = 0; i < word.length(); i++) {
            charCount[word.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charCount.length; i++) {
            sb.append("|");
            sb.append(charCount[i]);
        }
        return sb.toString();
    }
}