package singlenum;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{1,1,2,2,3,3,4,4,6}));
    }

    public int singleNumber(int[] nums) {

        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
