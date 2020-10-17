package mergesortedarray;

public class Main {

    public static void main(String[] args) {

        final int[] result = {1, 2, 3, 0, 0, 0};
        new Solution().merge(result, 3, new int[]{2, 5, 6}, 3);
        for (int n : result) {
            System.out.print(n + ", ");
        }
    }

    public static class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int[] result = new int[nums1.length];

            int i = 0;
            int j = 0;
            int r = 0;

            while (r < result.length) {
                if (i < m && j < n) {
                    int n1 = nums1[i];
                    int n2 = nums2[j];

                    if (n1 < n2) {
                        result[r++] = n1;
                        i++;
                    } else {
                        result[r++] = n2;
                        j++;
                    }

                } else if (i < m) {
                    int n1 = nums1[i++];
                    result[r++] = n1;
                } else if (j < n) {
                    int n2 = nums2[j++];
                    result[r++] = n2;
                }
            }

            for (int ii = 0; ii < nums1.length; ii++) {
                nums1[ii] = result[ii];
            }
        }
    }

}
