package mountainpathway;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        solution(new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 9, 1},
                new int[]{1, 1, 1, 1, 1, 9, 1, 1},
                new int[]{1, 1, 1, 1, 9, 1, 1, 1},
                new int[]{1, 1, 1, 9, 9, 1, 1, 1},
                new int[]{1, 1, 9, 1, 1, 1, 1, 1},
                new int[]{1, 9, 9, 1, 1, 1, 1, 1},
                new int[]{9, 9, 1, 1, 1, 1, 1, 1},
                new int[]{9, 1, 1, 1, 1, 1, 1, 1},
        });

        solution(new int[][]{
                new int[]{1, 4, 1, 1, 1, 1, 1, 1},
                new int[]{1, 2, 5, 1, 1, 1, 1, 1},
                new int[]{1, 3, 5, 9, 1, 1, 1, 1},
                new int[]{1, 2, 6, 7, 1, 1, 1, 1},
                new int[]{1, 1, 2, 3, 3, 2, 1, 1},
                new int[]{7, 7, 8, 9, 2, 4, 1, 1},
                new int[]{1, 1, 1, 1, 1, 3, 3, 4},
                new int[]{1, 1, 1, 1, 1, 1, 1, 2},
        });

        solution(new int[][]{
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                new int[]{1, 1, 1, 1, 1, 1, 1, 1},
        });


        solution(new int[][]{//2
                new int[]{1, 1, 1, 1,},
                new int[]{1, 1, 1, 1,},
                new int[]{9, 1, 9, 9,},
                new int[]{9, 1, 1, 1,},
        });
    }

    private static void solution(int[][] land) {
        List<Pair> solution = new Solution().solution(
                land,
                new Pair(land.length - 1, land.length - 1));

        System.out.println();
        System.out.println();
        for (int l = 0; l < land.length; l++) {
            for (int c = 0; c < land[l].length; c++) {
                Pair p = new Pair(l, c);
                if (solution.contains(p)) {
                    System.out.print("█" + ", ");
                } else {

                    System.out.print(land[l][c] + ", ");
                }

            }
            System.out.println();
        }
    }

    public List<Pair> solution(int[][] land, Pair goal) {
        LinkedList<Pair> solution = new LinkedList<>();
        Pair initialPosition = new Pair(0, 0);
        solution(land, goal, initialPosition, solution, new HashSet<>());

        return solution;
    }

    private static int[][] MOVES = new int[][]{
            new int[]{1, 0},
            new int[]{0, 1},
            new int[]{0, -1},
            new int[]{-1, 0},
    };

    private boolean solution(int[][] land, Pair goal, Pair currPosition, LinkedList<Pair> pathWay, Set<Pair> visited) {
        pathWay.add(currPosition);
        visited.add(currPosition);

        if (currPosition.equals(goal)) {
            return true;
        }

        for (int[] move : MOVES) {

            int nextR = currPosition.getR() + move[0];
            int nextC = currPosition.getC() + move[1];
            if (isValid(land, nextR, nextC)) {
                Pair nextPosition = new Pair(nextR, nextC);
                int currHeight = land[currPosition.getR()][currPosition.getC()];
                int nextHeight = land[nextPosition.getR()][nextPosition.getC()];
                if (Math.abs(currHeight - nextHeight) <= 1) {
                    if (!visited.contains(nextPosition)) {
                        boolean res = solution(land, goal, nextPosition, pathWay, visited);
                        if (res) return res;
                    }
                }
            }
        }
        pathWay.removeLast();
        visited.remove(currPosition);

        return false;
    }

    private boolean isValid(int[][] land, int r, int c) {
        return r >= 0 && r < land.length && c >= 0 && c < land.length;
    }

}
