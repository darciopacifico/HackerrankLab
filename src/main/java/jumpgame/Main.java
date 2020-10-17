package jumpgame;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().canJump(new int[]{0}));
    }

    public static final class Solution {
        public boolean canJump(int[] nums) {
            return canJump(nums, 0);
        }

        private boolean canJump(int[] nums, int pos){



            if(pos>=nums.length-1){
                return true;

            }else{

                int jumps = nums[pos];

                for(int i=jumps; i>=1; i--){
                    boolean res = canJump(nums, pos+i);
                    if(res)
                        return true;

                }

            }

            return false;

        }
    }

    public static class OptimalSolution {
        private boolean[] failed=new boolean[0];

        public boolean canJump(int[] nums) {

            int lastHope=nums.length-1;

            for(int i=nums.length-1; i>=0; i--){

                if(i+nums[i]>=lastHope){
                    lastHope = i;
                }

            }

            return lastHope==0;
        }

    }

}
