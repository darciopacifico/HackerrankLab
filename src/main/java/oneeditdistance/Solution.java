package oneeditdistance;

import java.util.PrimitiveIterator;

import static java.lang.Math.abs;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isOneEditDistance("ab", "acb") + " must be true");

        System.out.println(new Solution().isOneEditDistance("cab", "ad") + " must be false");
        System.out.println(new Solution().isOneEditDistance("ab", "cab") + " must be true");
        System.out.println(new Solution().isOneEditDistance("cab", "ab") + " must be true");
        System.out.println(new Solution().isOneEditDistance("a", "") + " must be true");
        System.out.println(new Solution().isOneEditDistance("", "a") + " must be true");
        System.out.println(new Solution().isOneEditDistance("1203", "1213") + " must be true");

    }

    public boolean isOneEditDistance(String s, String t) {
        if (s.length() > t.length())
            return isOneEditDistance(t, s);

        int ns = s.length();
        int nt = t.length();

        for (int i = 0; i < ns; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (ns == nt)
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else
                    return s.substring(i).equals(t.substring(i + 1));
            }
        }

        return ns + 1 == nt;
    }

    public boolean isOneEditDistance_mine(String s, String t) {
        if (s.isEmpty() && t.isEmpty()) return false;
        if (s.equals(t)) return false;
        if (abs(s.length() - t.length()) > 1) return false;

        if (s.length() < t.length()) {
            return isOneDeleteDistance(s, t);
        } else if (s.length() > t.length()) {
            return isOneInsertDistance(s, t);
        } else {
            return isOneUpdateDistance(s, t);
        }
    }

    private boolean isOneDeleteDistance(String s, String t) {

        if (s.length() == 0 && t.length() == 1) return true;

        PrimitiveIterator.OfInt iterator = getIterator(s);

        PrimitiveIterator.OfInt iterator1 = getIterator(t);

        int deletionCount = isOneDeleteDistance(iterator, iterator1, 0);
        return deletionCount == 1;
    }

    private java.util.PrimitiveIterator.OfInt getIterator(String t) {

        return t.chars().iterator();


    }

    private int isOneDeleteDistance(PrimitiveIterator.OfInt iterS, PrimitiveIterator.OfInt iterT, int deletes) {
        while (iterS.hasNext() || iterT.hasNext()) {

            Integer sChar = iterS.hasNext() ? iterS.next() : null;

            while (iterT.hasNext()) {
                Integer tChar = iterT.next();

                if (tChar.equals(sChar)) {
                    break;
                } else {
                    deletes++;
                }
                if (deletes > 1) return deletes;
            }
            if (deletes > 1) return deletes;

        }
        return deletes;
    }

    private boolean isOneInsertDistance(String s, String t) {
        return isOneDeleteDistance(t, s);
    }

    private boolean isOneUpdateDistance(String s, String t) {
        int editCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) editCount++;

            if (editCount > 1) return false;
        }
        return true;
    }
}
