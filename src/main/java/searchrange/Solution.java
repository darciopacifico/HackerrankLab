package searchrange;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] ints1 = new Solution().searchRange(new int[]{7, 7}, 7);

        Arrays.stream(ints1).forEach(System.out::println);


    }

    public int[] searchRange(int[] nums, int target) {
        int pivot = Arrays.binarySearch(nums, target);

        if (pivot < 0) return new int[]{-1, -1};

        int min = findMin(nums, 0, pivot, target);
        int max = findMax(nums, pivot, nums.length - 1, target);

        return new int[]{min, max};
    }

    private int findMin(int[] nums, int start, int end, int target) {

        int mid = start + ((end - start) / 2);

        if (nums[mid] == target && (mid == 0 || mid == nums.length - 1 || nums[mid - 1] < target)) return mid;

        if (nums[mid] > target) {
            return findMin(nums, start, mid - 1, target);
        }
        return findMin(nums, mid + 1, end, target);


    }

    private int findMax(int[] nums, int start, int end, int target) {

        int mid = start + ((end - start) / 2);

        if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) return mid;

        if (nums[mid] > target) {
            return findMax(nums, start, mid - 1, target);
        }
        return findMax(nums, mid + 1, end, target);


    }


}
