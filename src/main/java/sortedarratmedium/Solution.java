package sortedarratmedium;

public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(
                new int[]{3},
                new int[]{-2, -1}
        ));

    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {


        if (nums1.length > 0 && nums2.length > 0) {
            double m1 = findMedian(nums1);
            double m2 = findMedian(nums2);

            return (m1 + m2) / 2;
        } else if (nums1.length > 0) {
            return findMedian(nums1);
        } else /*if (nums2.length > 0) */ {
            return findMedian(nums2);
        }

    }

    private double findMedian(int[] nums1) {

        if (nums1.length % 2 == 0) {

            int mid2 = nums1.length / 2;
            int mid1 = mid2 - 1;

            double n1 = nums1[mid1];
            double n2 = nums1[mid2];

            return (n2 + n1) / 2;

        } else {
            int mid = nums1.length / 2;

            return nums1[mid];
        }
    }

}
