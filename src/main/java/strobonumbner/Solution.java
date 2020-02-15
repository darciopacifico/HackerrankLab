package strobonumbner;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    //                       0, 1, 2,  3,  4, 5, 6,  7, 8, 9
    int mirror[] = new int[]{0, 1, 2, -1, -1, 5, 9, -1, 8, 6};

    int[] strobs = new int[]{1, 6, 8, 9};


    public static void main(String[] args) {
        //this program was not finished.
        new Solution().findStrobogrammatic(5).forEach(System.out::println);
    }

    public List<String> findStrobogrammatic(int n) {
        LinkedList<String> result = new LinkedList<>();

        findStrobogrammatic(n, n, new LinkedList<>(), result);

        return result;
    }

    private void findStrobogrammatic(int n, int o, LinkedList<Integer> characters, LinkedList<String> result) {

        int halfWay = (o / 2);

        if (n == halfWay) {
            if (!characters.isEmpty()) {
                result.add(toString(o, characters));
            }
            return;
        }

        for (int strob : strobs) {
            characters.add(strob);
            findStrobogrammatic(n - 1, o, characters, result);
            characters.removeLast();
        }
    }

    private String toString(int o, LinkedList<Integer> characters) {

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
