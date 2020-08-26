package missingnumber;

import java.util.Arrays;

public class Solution {
    //Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{3, 0, 1}) + " : 2");
        System.out.println(new Solution().missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}) + " : 8");
    }

    public int missingNumber(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
