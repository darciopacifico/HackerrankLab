package numberofislandsII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private boolean debug = true;

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> islandCountPerTurn = solution.numIslands2(3, 3, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{1, 0},
                new int[]{0, 2},
                new int[]{0, 0},
                new int[]{1, 1}
        });

        if (solution.debug) {
            System.out.println();
            System.out.println("result:");
            islandCountPerTurn.forEach(System.out::println);
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        InternalSolution internalSolution = new InternalSolution(m, n);

        List<Integer> numberOfIslands = new ArrayList<>(positions.length);
        for (int[] position : positions) {
            numberOfIslands.add(internalSolution.addIsland(position[0], position[1]));
        }
        return numberOfIslands;
    }

    class InternalSolution {
        public final int[][] MOVES = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0},
        };

        private final int[][] grid;
        //private Set<Integer> islandIds = new HashSet<>();
        private Integer islandId = 1;
        private int[] parentIsland;
        private Set<Integer> islandIds = new HashSet();

        public InternalSolution(int m, int n) {
            this.grid = new int[m][n];

            this.parentIsland = new int[(m * n) + 1];
            for (int i = 0; i < parentIsland.length; i++)
                parentIsland[i] = i;

        }

        public Integer addIsland(int i, int j) {

            if (grid[i][j] == 0) {
                grid[i][j] = islandId++;
                this.islandIds.add(grid[i][j]);
                for (int[] move : MOVES) {

                    final int iAdj = i + move[0];
                    final int jAdj = j + move[1];

                    if (iAdj >= 0 && iAdj < grid.length && jAdj >= 0 && jAdj < grid[0].length) {
                        int adjacent = grid[iAdj][jAdj];

                        if (adjacent != 0) {
                            int adjTopParent = getParentIsland(adjacent);

                            if (grid[i][j] != adjTopParent) {
                                this.islandIds.remove(adjTopParent);//it will not be a top parent anymore
                            }

                            parentIsland[adjTopParent] = grid[i][j];
                        }
                    }
                }
            }

            if (debug) {
                System.out.println();
                for (int k = 0; k < grid.length; k++) {
                    System.out.println();
                    for (int l = 0; l < grid[0].length; l++) {
                        final int parentIsland = getParentIsland(grid[k][l]);
                        System.out.print((parentIsland == -1 ? "*" : parentIsland) + " - ");
                    }
                }
                System.out.println();

                for (int k = 0; k < parentIsland.length; k++) {
                    System.out.print(parentIsland[k] + ", ");
                }
                System.out.println();

                System.out.println("Island count: " + (Integer) this.islandIds.size());
            }

            return this.islandIds.size();
        }

        private int getParentIsland(int islandId) {
            if (islandId == 0) return 0;
            int parentIsland = this.parentIsland[islandId];

            if (parentIsland != islandId) {
                int grandpa = getParentIsland(parentIsland);
                this.parentIsland[islandId] = grandpa;
            }

            return this.parentIsland[islandId];
        }

    }

}
