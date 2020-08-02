package stonemove;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().removeStones(new int[][]{
                new int[]{0, 1},
                new int[]{1, 0}
        }));

        System.out.println(new Solution().removeStones(new int[][]{
                new int[]{0, 0},
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{2, 1},
                new int[]{2, 2}
        }));

        System.out.println(new Solution().removeStones(new int[][]{
                new int[]{0, 0},
                new int[]{0, 2},
                new int[]{1, 1},
                new int[]{2, 0},
                new int[]{2, 2}
        }));
    }


    public int removeStones(int[][] stones) {

        DFS dfs = new DFS();

        for (int[] stone : stones) {
            dfs.union(stone[0], stone[1] + 10000);
        }

        Set<Integer> uniqueSets = new HashSet<>();

        System.out.println(dfs.rootCount);

        for (int[] stone : stones) {
            uniqueSets.add(dfs.find(stone[0]));
        }

        return stones.length - uniqueSets.size();
    }

    public static class DFS {

        int rootCount = 0;

        public int[] parent = new int[20000];

        public DFS() {
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }

        public int getRootCount() {
            return rootCount;
        }

        public int find(int i) {
            if (parent[i] == i) {
                rootCount++;
                return parent[i];
            }

            parent[i] = find(parent[parent[i]]);

            return parent[i];
        }

    }

}
