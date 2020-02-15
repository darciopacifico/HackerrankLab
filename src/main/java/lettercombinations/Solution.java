package lettercombinations;

import java.util.LinkedList;
import java.util.List;

public class Solution {

    public final static char[][] mapChars = new char[][]{
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 't'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> results = new LinkedList<String>();
        if (digits == null || digits.isEmpty()) return results;

        LinkedList<Character> word = new LinkedList<Character>();

        letterCombinations(digits, 0, results, word);

        return results;
    }

    public void letterCombinations(String digits, int i, List<String> results, LinkedList<Character> word) {

        if (i >= digits.length()) {
            results.add(toWord(word));
            return;
        }

        int i1 = digits.charAt(i) - '0';

        for (char c : mapChars[i1]) {
            word.add(c);

            letterCombinations(digits, i + 1, results, word);

            word.removeLast();
        }

    }

    private String toWord(List<Character> word) {
        char[] chars = new char[word.size()];

        for (int i = 0; i < word.size(); i++) {
            chars[i] = word.get(i);
        }

        return new String(chars);
    }
}
