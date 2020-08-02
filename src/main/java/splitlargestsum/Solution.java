package splitlargestsum;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }

    public int splitArray(int[] nums, int m) {
        float d = (float) sum(nums) / (float) m;

        int diff = Integer.MAX_VALUE;



        return 1;
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
