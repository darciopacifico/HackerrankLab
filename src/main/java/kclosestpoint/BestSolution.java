package kclosestpoint;

import java.util.Arrays;

public class BestSolution {
    public int[][] kClosest(int[][] points, int K) {
        quickSelect(points, K, 0, points.length - 1);

        return Arrays.copyOfRange(points, 0, K);
    }

    private void quickSelect(int[][] points, int K, int left, int right) {
        int[] partitionVal = points[left + (int) (Math.random() * (right - left + 1))];
        int l = left;

        for (int i = left; i <= right; i++) {
            if (compare(points[i], partitionVal) <= 0) {
                int[] temp = points[l];
                points[l] = points[i];
                points[i] = temp;
                l++;
            }
        }

        if (l < K) {
            quickSelect(points, K, l, right);
        } else if (l > K) {
            quickSelect(points, K, left, l - 1);
        }
    }

    private int compare(int[] left, int[] right) {
        return left[0] * left[0] + left[1] * left[1]
                - right[0] * right[0] - right[1] * right[1];
    }


}