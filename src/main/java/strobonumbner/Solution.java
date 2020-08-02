package strobonumbner;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    //                       0, 1, 2,  3,  4, 5, 6,  7, 8, 9
    int mirror[] = new int[]{0, 1, 2, -1, -1, 5, 9, -1, 8, 6};

    int[] strobs = new int[]{0, 1, 6, 8, 9};

    public static void main(String[] args) {
        //this program was not finished.
        new Solution().findStrobogrammatic(3).forEach(System.out::println);
    }

    public List<String> findStrobogrammatic(int n) {
        LinkedList<String> result = new LinkedList<>();

        findStrobogrammatic(n, n, new ArrayList<>(n), result);

        if (n == 1) result.add("0");

        return result;
    }

    private void findStrobogrammatic(int n, int o, List<Integer> characters, LinkedList<String> result) {

        int halfWay = (o / 2);

        if (n == halfWay) {
            if (!characters.isEmpty()) {
                result.add(toString(o, characters));
            }
            return;
        }

        for (int strob : strobs) {
            if (isZeroDigitAtLeft(characters, strob)) continue;

            if (isMiddleDigit(n, o, halfWay) && isNotMirrorableChar(strob)) {
                continue;
            }

            characters.add(strob);
            findStrobogrammatic(n - 1, o, characters, result);
            if (!characters.isEmpty())
                characters.remove(characters.size() - 1);
        }
    }

    private boolean isZeroDigitAtLeft(List<Integer> characters, int strob) {
        return characters.isEmpty() && strob == 0;
    }

    private boolean isNotMirrorableChar(int strob) {
        return strob == 6 || strob == 9;
    }

    private boolean isMiddleDigit(int n, int o, int halfWay) {
        return (o % 2 == 1) && (n - 1) == halfWay;
    }

    private String toString(int o, List<Integer> characters) {

        char[] charsPrimitive = new char[o];

        int i = 0;
        for (Integer c : characters) {

            charsPrimitive[i] = (char) (c + '0');
            charsPrimitive[o - 1 - i] = (char) (mirror[c] + '0');

            i++;
        }


        return new String(charsPrimitive);
    }
}