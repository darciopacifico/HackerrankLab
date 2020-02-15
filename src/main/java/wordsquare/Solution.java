package wordsquare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {

    Map<String, Set<String>> wordPrefix = new HashMap<>();


    int wordSize;
    private String[] words;

    public static void main(String[] args) {
        System.out.println(new Solution().wordSquares(new String[]{"area", "lead", "wall", "lady", "ball"}));

    }

    void setWordPrefixMap(String[] words) {
        this.words = words;

        for (String word : words) {

            for (int i = 0; i < word.length() + 1; i++) {

                String keyPrefix = word.substring(0, i);

                if (!wordPrefix.containsKey(keyPrefix))
                    wordPrefix.put(keyPrefix, new HashSet<>());

                wordPrefix.get(keyPrefix).add(word);

            }

        }

    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> results = new LinkedList<>();
        if (words.length == 0) {
            return results;
        }

        wordSize = words[0].length();
        this.setWordPrefixMap(words);

        List<String> wordStacked = new ArrayList<>(wordSize);
        wordSquares("", wordStacked, results);

        return results;
    }

    private void wordSquares(String prefix, List<String> wordStacked, List<List<String>> results) {
        if (!this.wordPrefix.containsKey(prefix)) {
            return;
        }

        for (String prefixedWord : this.wordPrefix.get(prefix)) {

            wordStacked.add(prefixedWord);
            if (wordStacked.size() == wordSize) {
                results.add(new ArrayList<>(wordStacked));
                //results.add(new LinkedList<>(wordStacked));

            } else {
                int wantedChar = prefix.length() + 1;

                String newPrefix = getNextPrefix(wordStacked, wantedChar);

                wordSquares(newPrefix, wordStacked, results);
            }


            wordStacked.remove(wordStacked.size() - 1);
        }
    }

    private String getNextPrefix(List<String> wordStacked, int wantedChar) {
        char[] chars = new char[wantedChar];

        for (int i = 0; i < wordStacked.size(); i++) {
            chars[i] = wordStacked.get(i).charAt(wantedChar);
        }

        return new String(chars);
    }

}