/**
 * Created by darcio on 9/3/16.
 */
public class MaximizeMaxGroupAbs {

    public static void main(String[] args) {

        int[] arr = new int[]{32, 3, 54, 6, 7, 8, 30};

        int maxDiff = maxAbsDig(arr);
        System.out.println(maxDiff);


    }

    public static int maxAbsDig(int[] arr) {
        int[] maxLR = new int[arr.length];

        int champ = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            champ = Math.max(arr[i], champ);
            maxLR[i] = champ;
        }

        champ = Integer.MIN_VALUE;

        int champDiff = Integer.MIN_VALUE;

        for (int i = arr.length - 1; i >= 0; i--) {
            champ = Math.max(arr[i], champ);

            champDiff = Math.max(champDiff, Math.abs(champ - maxLR[i]));

        }

        return champDiff;
    }
}
