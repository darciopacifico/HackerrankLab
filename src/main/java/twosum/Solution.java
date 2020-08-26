package twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(printRes(new Solution().twoSum(new int[]{2, 5, 5, 11}, 10)));
        System.out.println(printRes(new Solution().twoSum(new int[]{3, 3}, 6)));
        System.out.println(printRes(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    private static String printRes(int[] nums) {
        return nums[0] + "," + nums[1];
    }


    public int[] twoSum(int[] nums, int target) {

        final Map<Integer, Integer> allNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            final int num = nums[i];

            final int otherNum = target - num;

            if (allNums.containsKey(otherNum)) {
                final int otherNumIndex = allNums.get(otherNum);
                return new int[]{otherNumIndex, i};
            }
            allNums.put(nums[i], i);
        }

        return null;
    }


}
