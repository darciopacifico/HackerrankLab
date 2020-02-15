package generateparenthesis;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        new Solution().generateParenthesis(5)
                .forEach(System.out::println);
    }

    public List<String> generateParenthesis(int n) {
        List<String> results = new LinkedList<>();

        generateParenthesis(n, 0, new LinkedList<>(), results);

        return results;
    }

    private void generateParenthesis(int remaining, int closeStack, LinkedList<Character> word, List<String> results) {

        if (remaining == 0 && closeStack == 0) {
            results.add(getWord(word));
            return;
        }

        if (remaining > 0) {
            word.add('(');
            generateParenthesis(remaining - 1, closeStack + 1, word, results);
            word.removeLast();
        }

        if (closeStack > 0) {
            word.add(')');
            generateParenthesis(remaining, closeStack - 1, word, results);
            word.removeLast();

        }
    }

    private String getWord(LinkedList<Character> word) {
        char[] chars = new char[word.size()];
        int i = 0;
        for (Character c : word) {
            chars[i++] = c;
        }
        return new String(chars);
    }

}
