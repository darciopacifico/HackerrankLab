package jumpgameii;

public class Main {

    public static void main(String[] args) {

        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));

    }

    public static class Solution {
        public int jump(int[] nums) {

            int lastHope = nums.length - 1;

            int hopeCount = 0;

            for (int i = 0; i <= lastHope; i++) {


                if (i + nums[i] >= lastHope) {
                    hopeCount++;
                    lastHope = i;
                    i = -1;
                }


                if (lastHope == 0) break;

            }

            return lastHope == 0 ? hopeCount : -1;
        }
    }

}
