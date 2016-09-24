/**
 * Created by darcio on 9/15/16.
 */
public class Solution1 {


    public static void main(String[] args) {

        System.out.println(
                maxDifference(new int[]{2, 3, 10, 2, 4, 8, 1})
        );

        System.out.println(
                maxDifference(new int[]{7, 9, 5, 6, 3, 2})
        );

        System.out.println(
                maxDifference(new int[]{1,2,3,4,5,6,7,8,9})
        );

        System.out.println(
                maxDifference(new int[]{9,8,7,6,5,4,3,2,1})
        );

    }

    static int maxDifference(int[] a) {
        int[] maxes = new int[a.length];
        int max = Integer.MIN_VALUE;
        for (int i = a.length - 1; i >= 0; i--) {
            max = Math.max(max, a[i]);
            maxes[i] = max;
        }

        int maxDiff = -1;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            min = Math.min(min, a[i]);

            maxDiff = Math.max(maxDiff, maxes[i] - min);
        }

        if(maxDiff==0){
            return -1;
        }else {
            return maxDiff;

        }

    }

}

