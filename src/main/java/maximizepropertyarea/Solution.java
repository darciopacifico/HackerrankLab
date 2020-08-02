package maximizepropertyarea;

import static java.lang.System.out;

public class Solution {

    public static void main(String[] args) {
        out.println(new Solution().maxProperties(
                new int[]{4, 6, 3, 1, 1, 5, 9, 6, 7, 9, 6, 4, 7, 8, 9, 6, 4, 6, 7, 8},
                //        0, 1, 2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19
                0));
        out.println(new Solution().maxProperties(
                new int[]{4, 6, 3, 1, 1, 5, 9, 6, 7, 9, 6, 4, 7, 8, 9, 6, 4, 6, 7, 8},
                //        0, 1, 2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19
                2));
        out.println(new Solution().maxProperties(
                new int[]{4, 6, 3, 20, 1, 5, 9, 6, 7, 9, 6, 4, 7, 8, 9, 6, 4, 6, 7, 8},
                //        0, 1, 2  3   4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19
                50));
        out.println(new Solution().maxProperties(
                new int[]{4, 6, 3, 20, 1, 5, 1, 1, 1, 1, 1, 1, 1, 8, 9, 6, 4, 6, 7, 8},
                //        0, 1, 2  3   4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19
                7));
        out.println(new Solution().maxProperties(
                new int[]{4},
                //        0
                4));
        out.println(new Solution().maxProperties(
                new int[]{4},
                //        0
                2));

    }

    public int maxProperties(int[] properties, final int budget) {
        if (properties.length == 0) return 0;
        int l = 0;
        int r = 0;
        int bestL = 0;
        int bestR = 0;
        int spent = 0;
        int max = r - l;

        do {
            if (spent < budget) {
                spent += properties[r];
                r++;
            } else {
                spent -= properties[l];
                l++;
            }

            if ((r - l) > max && spent <= budget) {
                max = r - l;
                bestL = l;
                bestR = r;
            }

        } while (r < properties.length);

        out.print("start l=" + bestL + " r=" + bestR + " ");
        return max;
    }
}
