package maxsubarray;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{-1,-2}));
    }

    public static final class Solution {
        public int maxSubArray(int[] nums) {

            int sum = 0;
            int bestL = 0;
            int bestR = 0;
            int bestSum = Integer.MIN_VALUE;

            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];

                if (sum > bestSum) {
                    bestSum = sum;
                    bestL = i;
                }
            }

            sum = 0;
            bestSum = Integer.MIN_VALUE;
            for (int i = nums.length - 1; i >= 0; i--) {
                sum += nums[i];

                if (sum > bestSum) {
                    bestSum = sum;
                    bestR = i;
                }
            }

            int l = Math.min(bestL, bestR);
            int r = Math.max(bestL, bestR);

            sum = 0;
            for (int i = l; i <= r; i++) {
                sum += nums[i];
            }

            return sum;
        }
    }
}
