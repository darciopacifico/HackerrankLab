package sumnum;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Solution().subarraySum(new int[]{1},0));
    }

    public static class Solution {
        public int subarraySum(int[] nums, int k) {

            int l=0;
            int r=0;

            int count=0;

            int currSum=0;

            while(l<nums.length && r<nums.length ){

                if(currSum<=k){
                    if(r==nums.length){
                        break;
                    }
                    currSum += nums[r++];
                }else{
                    if(l<r-1)
                        currSum -= nums[l++];
                }


                if(currSum==k){
                    count++;
                }


            }


            return count;
        }
    }
}
