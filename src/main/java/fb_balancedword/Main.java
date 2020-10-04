package fb_balancedword;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().minRemoveToMakeValid("(((ab)))"));
        System.out.println(new Main().minRemoveToMakeValid("(((ab)"));
        System.out.println(new Main().minRemoveToMakeValid("a)(b"));
        System.out.println(new Main().minRemoveToMakeValid("((()((abc"));
    }

    public String minRemoveToMakeValid(String word) {

        Stack<Integer> indexes = new Stack<>();

        char[] wordChars = word.toCharArray();

        for (int i = 0; i < wordChars.length; i++) {

            char c = wordChars[i];

            if (c == '(') {
                indexes.add(i);
                wordChars[i] = ' ';

            } else if (c == ')') {

                if (!indexes.isEmpty()) {
                    Integer indexClosing = indexes.pop();
                    wordChars[indexClosing] = '(';
                    wordChars[i] = ')';
                }else{
                    wordChars[i] = ' ';
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] != ' ')
                sb.append(wordChars[i]);

        }

        return sb.toString();

    }
}
