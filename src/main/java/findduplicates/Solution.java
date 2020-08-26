package findduplicates;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicate(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9}));
        System.out.println(new Solution().findDuplicate(new int[]{1, 4, 3, 2, 5, 6, 7, 8, 9, 9}));
        System.out.println(new Solution().findDuplicate(new int[]{1, 2, 5, 4, 3, 6, 7, 8, 9, 9}));
    }

    public int findDuplicate(int[] nums) {
        return findDuplicate3(nums);
    }

    int findDuplicate3(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
