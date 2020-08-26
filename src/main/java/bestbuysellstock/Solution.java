package bestbuysellstock;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 4, 5, 6}));
    }


    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE - 1;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {

            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);

        }
        return maxProfit;
    }
}
