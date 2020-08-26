package numberofislandsIInogrid;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    private boolean debug = true;

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> islandCountPerTurn = solution.numIslands2(3, 3, new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{1, 0},
                new int[]{0, 0},
                new int[]{2, 2},
                new int[]{1, 2},
                new int[]{1, 1},
                new int[]{0, 1}
        });

        if (solution.debug) {
            System.out.println();
            System.out.println("result:");
            islandCountPerTurn.forEach(System.out::println);
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        InternalSolution internalSolution = new InternalSolution(m, n);

        List<Integer> numberOfIslands = new LinkedList<>();
        for (int i = 0; i < positions.length; i++) {
            int[] position = positions[i];
            final Integer e = internalSolution.addIsland(position[0], position[1]);
            numberOfIslands.add(e);
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

        private int[] parentIsland;
        //private Set<Integer> islandIds_ = new HashSet();
        private int islandCount = 0;
        private int m;
        private int n;

        public InternalSolution(int m, int n) {
            this.m = m;
            this.n = n;

            this.parentIsland = new int[(m * n) + 1];
            for (int i = 0; i < parentIsland.length; i++)
                parentIsland[i] = -1;

        }

        public Integer addIsland(int i, int j) {
            int idIlha = toUnidimId(i, j);

            if (parentIsland[idIlha] == -1) { // is it empty
                parentIsland[idIlha] = idIlha;
                //this.islandIds.add(idIlha);
                islandCount++;

                for (int[] move : MOVES) {

                    final int iAdj = i + move[0];
                    final int jAdj = j + move[1];

                    if (iAdj >= 0 && iAdj < m && jAdj >= 0 && jAdj < n) {
                        int adjacent = toUnidimId(iAdj, jAdj);

                        if (parentIsland[adjacent] != -1) {
                            union(idIlha, adjacent);
                        }
                    }
                }
            }

            if (debug) {
                System.out.println();
                for (int k = 0; k < m; k++) {
                    System.out.println();
                    for (int l = 0; l < n; l++) {
                        final int islandId = toUnidimId(k, l);
                        final int parentIsland = this.parentIsland[islandId] != -1 ? getParentIsland(islandId) : -1;
                        System.out.print((parentIsland == -1 ? "*" : parentIsland) + " - ");
                    }
                }
                System.out.println();

                for (int k = 0; k < parentIsland.length; k++) {
                    System.out.print(parentIsland[k] + ", ");
                }
                System.out.println();

//                System.out.println("Island count: " + (Integer) this.islandIds.size());
                System.out.println("Island count: " + (Integer) this.islandCount);
            }

            //return this.islandIds.size();
            return this.islandCount;
        }

        private void union(int idIlha, int islandId) {
            int adjTopParent = getParentIsland(islandId);

            if (idIlha != adjTopParent) {
                islandCount--;
                //this.islandIds.remove(adjTopParent);//it will not be a top parent anymore
            }

            parentIsland[adjTopParent] = idIlha;
        }

        private int toUnidimId(int i, int j) {
            return (i * n) + j;
        }

        private int getParentIsland(int islandId) {
            int parentIsland = this.parentIsland[islandId];

            if (parentIsland != islandId) {
                int grandpa = getParentIsland(parentIsland);
                this.parentIsland[islandId] = grandpa;
            }

            return this.parentIsland[islandId];
        }

    }

}
