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


import java.util.*;

public class CodilityVacationTripsSortedSet {

    public static void main(String[] args) {
        //  0  1  2  3  4  5  6  7                                           -------------------
        System.out.println(solution(new int[]{7, 3, 7, 3, 1, 3, 4, 1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 2, 1, 1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 6, 2, 1, 1}));
        System.out.println(solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(solution(new int[]{1, 2, 4, 4, 4, 4, 7, 8}));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(solution(new int[]{1, 2, 2, 3, 2, 1, 1, 1}));
        System.out.println(solution(new int[]{1, 1, 2, 2, 3, 3, 1, 2, 3, 3, 2, 2, 1, 1}));
    }

    public static int solution(int[] A) {
        Set<Integer> trips = new HashSet<>();

        for (int i = 0; i < A.length; i++)
            trips.add(A[i]);

        final int qtd = trips.size();

        if(qtd==0) return 0;

        //if (qtd == 1 || qtd == 2) return qtd;
        int champ = Integer.MAX_VALUE;

        Map<Integer, Integer> tripDay = new HashMap<>();

        SortedSet<Integer> sset = new TreeSet<>();

        for (int day = 0; day < A.length; day++) {

            //trip deste dia
            int trip = A[day];

            //
            if (tripDay.containsKey(trip))
                sset.remove(tripDay.get(trip));

            sset.add(day);
            tripDay.put(trip, day);

            if (tripDay.size() == qtd) {
                champ = Math.min(champ, sset.last() - sset.first() + 1);
            }

            assert sset.size() == tripDay.size();
        }
        return champ;
    }
}