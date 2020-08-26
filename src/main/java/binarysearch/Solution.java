package binarysearch;

public class Solution {

    public static void main(String[] args) {


        System.out.println(new Solution().findMin(new int[]{10, 1, 10, 10, 10}));
        /*
        System.out.println(new Solution().findMin(new int[]{2, 2, 2, 0, 1}));
        System.out.println(new Solution().findMin(new int[]{2, 1}));
        System.out.println(new Solution().findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(new Solution().findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        //                                                  0  1  2  3  4  5  6
        * */

    }


    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        return findMin(nums, 0, nums.length - 1);

    }

    private int findMin(int[] nums, int l, int r) {
        if (l == r) return nums[l];

        if (nums[l] < nums[r]) {
            return nums[l];
        }

        if (nums[l] == nums[r]) {
            return findMin(nums, ++l, r);
        }

        int mid = l + (r - l) / 2;

        if (nums[mid] >= nums[l])
            return findMin(nums, mid + 1, r);
        else
            return findMin(nums, l, mid);


    }


}
