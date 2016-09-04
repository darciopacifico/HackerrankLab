/*

    A[0] = 7
    A[1] = 3
    A[2] = 7
    A[3] = 3
    A[4] = 1
    A[5] = 3
    A[6] = 4
    A[7] = 1
* */


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TripsQuadratic {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{7, 3, 7, 3, 1, 3, 4, 1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 2, 1, 1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 6, 2, 1, 1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(solution(new int[]{1, 2, 4, 4, 4, 4, 7, 8}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(solution(new int[]{1, 2, 2, 3, 2, 1, 1, 1}));
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 1, 2, 3, 3, 2, 2, 1, 1,}));
    }

    public static int solution(int[] A) {
        Set<Integer> ida = new HashSet<Integer>();
        for (int i = 0; i < A.length; i++)
            ida.add(A[i]);

        int opcoes = ida.size();

        int champ = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            Set<Integer> setOpc = new HashSet<>();
            for (int y = i; y < A.length; y++) {
                setOpc.add(A[y]);
                if (setOpc.size() == opcoes) {
                    champ = Math.min(y - i + 1, champ);
                    break;
                }
            }
        }

        return champ;
    }
}


