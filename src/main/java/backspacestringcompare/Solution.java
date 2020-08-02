package backspacestringcompare;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("nzp#o#g", "b#nzp#o#g") + " must be true");
    }

    public static class Holder {
        int x;
    }

    public boolean backspaceCompare(String S, String T) {

        Holder i = new Holder();
        Holder j = new Holder();

        i.x = S.length() - 1;
        j.x = T.length() - 1;

        while (i.x >= 0 || j.x >= 0) {

            char cS = getChar(S, S.length() - 1, 0);
            char cT = getChar(T, T.length() - 1, 0);
            if (cS != cT) {
                return false;
            }

        }

        return true;

    }

    public char getChar(String s, int i, int deletes) {

        if (i == -1) return '@';

        char c = s.charAt(i - 1);

        if (c == '#') return getChar(s, i - 1, deletes + 1);

        if (deletes > 0) return getChar(s, i - 1, deletes - 1);

        return c;
    }
}
