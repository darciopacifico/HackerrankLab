package balancedParenthesis;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("{ { } [ ] [ [ [ ] ] ] }"));
        System.out.println(new Solution().isValid("{ { } [ ] [ [ [{ ] ] ] }"));
    }


    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {

            switch (c) {
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;

                case ' ':
                    break;
                default:
                    if (stack.isEmpty() || !stack.pop().equals(c))
                        return false;

            }

        }

        return stack.empty();
    }


}
