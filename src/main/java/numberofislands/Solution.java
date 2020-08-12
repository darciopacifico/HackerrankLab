package numberofislands;

public class Solution {
    public static void main(String[] args) {
        System.out.println("result " + new Solution().numIslands(
                new char[][]{
                        new char[]{'1', '1', '1'},
                        new char[]{'1', '0', '0'},
                        new char[]{'1', '1', '1'}
                }
        ));
    }

    public int numIslands(char[][] grid) {
        InternalSolution internalSolution = new InternalSolution(grid);
        return internalSolution.groupIslands();
    }

    class InternalSolution {
        private final char[][] grid;
        //private final int[][] groups;
        private int idInitial;
        //private final int minIdInitial;

        InternalSolution(char[][] grid) {
            //this.minIdInitial = grid.length * grid.length > 0 ? grid[0].length : 0;
            this.idInitial = 0;
            this.grid = grid;
            //this.groups = new int[grid.length][grid.length > 0 ? grid[0].length : 0];
        }

        private int groupIslands() {
            if (grid.length == 0 || grid[0].length == 0) return 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') { // part of an island
                        ++idInitial;
                        groupIslands(i, j);//let's crawl all adjacent points
                    }
                }
            }

            return idInitial;
        }

        private void groupIslands(int i, int j) {
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;

            if (grid[i][j] != '1') return; // adjacent cel not part of the island

            grid[i][j] = (char) ('1' + idInitial); // visited cell

            groupIslands(i - 1, j);
            groupIslands(i, j - 1);
            groupIslands(i + 1, j);
            groupIslands(i, j + 1);
        }
    }

}
