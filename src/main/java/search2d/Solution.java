package search2d;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().searchMatrix(new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 50},
        }, 35));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrix(matrix, target, 0, matrix.length - 1);
    }

    public boolean searchMatrix(int[][] matrix, int target, int l, int r) {

        if (matrix.length == 0) return false;

        if (l == r) return search(matrix[l], target);

        int mid = l + ((r - l) / 2);

        int[] row = matrix[mid];
        if (target < row[0]) {
            return searchMatrix(matrix, target, l, mid);
        } else if (target > row[row.length - 1]) {
            return searchMatrix(matrix, target, mid + 1, r);
        } else {
            return search(row, target);
        }


    }

    private boolean search(int[] matrix, int target) {
        return search(matrix, target, 0, matrix.length - 1);
    }

    private boolean search(int[] matrix, int target, int l, int r) {
        if (matrix.length == 0) return false;

        if (l == r) return matrix[l] == target;

        int mid = l + ((r - l) / 2);

        if (target > matrix[mid]) {
            return search(matrix, target, mid + 1, r);
        } else if (target < matrix[mid]) {
            return search(matrix, target, l, mid);
        }

        return matrix[mid] == target;
    }
}