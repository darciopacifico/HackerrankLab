package kclosestpoint;

import java.util.PriorityQueue;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.util.Comparator.comparingDouble;

public class Solution {


    public static void main(String[] args) {

        int[][] res = new Solution().kClosest(new int[][]{
                new int[]{1, 3},
                new int[]{-2, 2},
        }, 1);

        for (int i = 0; i < res.length; i++) {
            int[] r = res[i];

            System.out.println(r[0] + ", " + r[1]);
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<PointDistance> pq = new PriorityQueue<>(comparingDouble(x -> x.distance));

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];

            double distance;

            final int x = abs(point[0]);
            final int y = abs(point[1]);

            if (x == 0)
                distance = y;
            else if (y == 0)
                distance = x;
            else {
                double x_2 = pow(x, 2);
                double y_2 = pow(y, 2);
                distance = x_2 + y_2;
            }

            pq.add(new PointDistance(point, distance));
        }


        final int[][] ints = new int[k][2];

        for (int i = 0; i < k; i++) {
            ints[i] = pq.poll().point;
        }

        return ints;
    }

    static class PointDistance {
        private int[] point;
        private double distance;

        PointDistance(int[] point, double distance) {
            this.point = point;

            this.distance = distance;
        }

        public int[] getPoint() {
            return point;
        }

        public double getDistance() {
            return distance;
        }
    }
}
