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


import java.util.HashSet;
import java.util.Set;

public class CodilityVacationTrips {

    public static void main(String[] args) {
        //  0  1  2  3  4  5  6  7                                           -------------------
        System.out.println(new CodilityVacationTrips().solution(new int[]{7, 3, 7, 3, 1, 3, 4, 1}));
        //                                                                0  1  2  3  4  5  6  7

        //                                                                            -------
        System.out.println(new CodilityVacationTrips().solution(new int[]{1, 1, 1, 1, 1, 2, 1, 1}));
        //                                                                0  1  2  3  4  5  6  7

        //                                                                         ----------
        System.out.println(new CodilityVacationTrips().solution(new int[]{1, 1, 1, 1, 6, 2, 1, 1}));
        //                                                                0  1  2  3  4  5  6  7

        System.out.println(new CodilityVacationTrips().solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        //                                                                0  1  2  3  4  5  6  7

        //                                                                ----------------------
        System.out.println(new CodilityVacationTrips().solution(new int[]{1, 2, 4, 4, 4, 4, 7, 8}));
        //                                                                0  1  2  3  4  5  6  7

        //                                                                ----------------------
        System.out.println(new CodilityVacationTrips().solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        //                                                                0  1  2  3  4  5  6  7
    }

    public int solution(int[] A) {
        Set<Integer> trips = new HashSet<Integer>();
        Set<Integer> tripBack = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            trips.add(A[i]);
            tripBack.add(A[i]);
        }

        if (trips.size() == 1) {
            return 1;
        }


        Integer lastDay = A.length;
        for (int i = 0; i < A.length; i++) {
            if (trips.isEmpty()) {
                lastDay = i;
                break;
            }
            trips.remove(A[i]);
        }

        Integer firstDay = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (tripBack.isEmpty()) {
                firstDay = i;
                break;
            }
            tripBack.remove(A[i]);
        }

        if (lastDay.equals(firstDay))
            return 2;
        else if (firstDay < lastDay)
            return lastDay - firstDay;
        else
            return 1;


    }
}


