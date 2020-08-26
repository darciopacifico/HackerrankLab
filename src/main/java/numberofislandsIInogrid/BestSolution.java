package numberofislandsIInogrid;

import java.util.ArrayList;
import java.util.List;

class BestSolution {
    int[] fathers;
    int numConnected;
    int m;
    int n;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (positions == null) return res;

        this.m = m;
        this.n = n;

        fathers = new int[n * m];
        for (int i = 0; i < m * n; ++i) {
            fathers[i] = -1;
        }

        for (int i = 0; i < positions.length; ++i) {
            addPoint(positions[i][0], positions[i][1]);
            res.add(numConnected);
        }

        return res;

    }

    private void addPoint(int x, int y) {
        int curr = x * n + y;
        if (fathers[curr] == -1) {
            fathers[curr] = curr;
            ++numConnected;
        }

        if (x - 1 >= 0 && fathers[curr - n] != -1) {
            union(curr - n, curr);
        }

        if (x + 1 < m && fathers[curr + n] != -1) {
            union(curr + n, curr);
        }

        if (y + 1 < n && fathers[curr + 1] != -1) {
            union(curr + 1, curr);
        }

        if (y - 1 >= 0 && fathers[curr - 1] != -1) {
            union(curr - 1, curr);
        }


    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            fathers[rootA] = rootB;
            numConnected--;
        }
    }

    private int find_(int a) {
        int root = a;
        while (fathers[root] != root) root = fathers[root];

        while (a != root) {
            int t = fathers[a];
            fathers[a] = root;
            a = t;
        }

        return root;
    }

    private int find(int islandId) {
        int parentIsland = this.fathers[islandId];

        if (parentIsland != islandId) {
            int grandpa = find(parentIsland);
            this.fathers[islandId] = grandpa;
        }

        return this.fathers[islandId];
    }
}