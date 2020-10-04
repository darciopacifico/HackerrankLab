package parentesiswildcard;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Main().isBalanced("()*)(*()(*"));//true
        System.out.println(new Main().isBalanced("(*))"));//true
        System.out.println(new Main().isBalanced("*()*)(*()****(*("));//false
        System.out.println(new Main().isBalanced("(*)"));//true
        System.out.println(new Main().isBalanced("(()((()))())"));//true
    }

    public boolean isBalanced(String s) {
        int openCount = 0;
        int starCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else if (s.charAt(i) == ')') {
                if (openCount <= 0) {
                    if (starCount > 0) {
                        starCount--;
                    } else {
                        return false;
                    }
                } else {
                    openCount--;
                }
            } else if (s.charAt(i) == '*') {
                starCount++;
            }
        }
        return openCount == 0;
    }

    private boolean validateStack(Stack<Character> stack) {

        int credits = 0;
        while (!stack.isEmpty()) {
            char c = stack.pop();

            if (c == '(') {
                if (credits > 0) {
                    credits--;
                } else {
                    return false;
                }
            } else {
                credits++;
            }
        }

        return true;
    }
}