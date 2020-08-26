package search2dii;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[]{1,   4,  7, 10, 11},
                new int[]{2,   5,  8, 12, 19},
                new int[]{3,   6,  9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30},

        }, 11));
        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[]{1,   4,  7, 11, 15},
                new int[]{2,   5,  8, 12, 19},
                new int[]{3,   6,  9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30},

        }, 20));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int r = matrix.length - 1;
        int c = 0;

        while (r >= 0 && c < matrix[0].length) {

            if (target < matrix[r][c]) {
                r--;
            } else if (target > matrix[r][c]) {
                c++;
            } else {
                return true;
            }
        }

        return false;
    }


}