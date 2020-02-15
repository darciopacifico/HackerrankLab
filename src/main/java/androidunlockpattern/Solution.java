package androidunlockpattern;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {

    public final static int[][] board = new int[][]{
            new int[]{1, 2, 3},
            new int[]{4, 5, 6},
            new int[]{7, 8, 9},
    };

    public static final int[][] moves = getMoves();
    private int countPattern = 0;

    public static void main(String[] args) {
        int x = new Solution().numberOfPatterns(1, 2);
        System.out.println(x);

    }

    private static int[][] getMoves() {
        int[] move = new int[]{-2, -1, 0, 1, 2};
        int[][] moves = new int[24][];

        int moveIndex = 0;

        for (int i = 0; i < move.length; i++) {
            for (int j = 0; j < move.length; j++) {
                if (move[i] == 0 && move[j] == 0)
                    continue;
                moves[moveIndex++] = new int[]{move[i], move[j]};
            }
        }

        return moves;
    }

    public int numberOfPatterns(int min, int max) {


        getCountPattern(min, max, 1, 0, 0);
        getCountPattern(min, max, 1, 0, 1);
        getCountPattern(min, max, 1, 0, 2);

        getCountPattern(min, max, 1, 1, 0);
        getCountPattern(min, max, 1, 1, 1);
        getCountPattern(min, max, 1, 1, 2);

        getCountPattern(min, max, 1, 2, 0);
        getCountPattern(min, max, 1, 2, 1);
        getCountPattern(min, max, 1, 2, 2);

        int countPattern = this.countPattern;
        this.countPattern = 0;
        return countPattern;
    }

    private void getCountPattern(int min, int max, int countDepth, int rDest, int cDest) {


        if (countDepth <= max) {

            int boardPost = board[rDest][cDest];

            board[rDest][cDest] = -1;
            if (countDepth >= min && countDepth <= max) {
                this.countPattern++;
            }

            for (int[] move : moves) {
                int rd = rDest + move[0];
                int cd = cDest + move[1];

                if (rd > 2 || rd < 0 || cd > 2 || cd < 0) {
                    //out of the board
                    continue;
                }

                if (board[rd][cd] < 0) {
                    //place already visited
                    continue;
                }

                int max1 = max(abs(move[0]), abs(move[1]));
                int min1 = min(abs(move[0]), abs(move[1]));

                if (max1 == 2 && (min1 == 2 || min1 == 0)) {
                    //check unblocked way
                    if (board[rDest + (move[0] / 2)][cDest + (move[1] / 2)] >= 0) {
                        //place in the way is non visited / blocked
                        continue;
                    }
                }
                getCountPattern(min, max, countDepth + 1, rd, cd);
            }

            board[rDest][cDest] = boardPost;
        }

    }


}
