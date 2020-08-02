package findMissingRanges;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    //Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
    //Output: ["2", "4->49", "51->74", "76->99"]

    public static void main(String[] args) {
        System.out.println(new Solution().findMissingRanges(new int[]{-1}, -1, -1)
                .stream().collect(Collectors.joining(", ")));
        System.out.println("");

        System.out.println(new Solution().findMissingRanges(new int[]{0, 1, 3, 50, 75}, 0, 99)
                .stream().collect(Collectors.joining(", ")));

        System.out.println("2, 4->49, 51->74, 76->99");
    }

    public List<String> findMissingRanges(int[] nums, final int lower, final int upper) {
        return Collections.emptyList();
    }

    private void addGap(int min, int max, List<String> gaps) {
        min = min + 1;
        max = max - 1;

        if (min == 0 && max == 0) return;

        if (min == max) {
            gaps.add(min + "");
            return;
        }

        gaps.add(min + "->" + max);
    }

}