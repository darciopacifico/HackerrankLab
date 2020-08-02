package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Arrays.asList(
                new Solution().merge(new int[][]{
                        new int[]{1, 3},
                        new int[]{4, 6},
                        new int[]{5, 7}
                })
        ).forEach(arrInterval -> System.out.println(arrInterval[0] + "-" + arrInterval[1]));
    }


    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> merged = new ArrayList<>(intervals.length);

        int[] currentInterval = intervals[0];
        for (int[] interval : intervals) {

            if (currentInterval[1] >= interval[0]) {
                currentInterval[1] = Math.max(interval[1], currentInterval[1]);

            } else {
                merged.add(currentInterval);
                currentInterval = new int[]{interval[0], interval[1]};
            }
        }

        if (currentInterval != null) merged.add(currentInterval);

        return merged.toArray(new int[merged.size()][]);

    }


}
