/**
 * Created by darcio on 8/29/16.
 */
public class CyclicArray {

    public static void main(String[] args) {
                                                //  0   1   2   3  4  5  6  7   8   9   10  11  12  13  14  15  16
        System.out.println(findCiclePoint(new int[]{15, 16, 17, 1, 2, 3, 4, 5,  6,  7,  8,  9,  10, 11, 12, 13, 14}));
        System.out.println(findCiclePoint(new int[]{3,  4,  5,  6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 1,  2}));
        System.out.println(findCiclePoint(new int[]{14, 15, 16, 17, 1, 2, 3, 4, 5,  6,  7,  8,  9,  10, 11, 12, 13}));
        System.out.println(findCiclePoint(new int[]{1, 2, 3, 4, 5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15, 16, 17}));
    }

    private static int findCiclePoint(int[] arr, int s, int e) {

        if (s == e) return s;

        int mid = s + ((e - s)/2);

        if (arr[s] >= arr[mid])
            return findCiclePoint(arr, s, mid);
        else
            return findCiclePoint(arr, mid, e);


    }

    private static int findCiclePoint(int[] arrInt) {
        return findCiclePoint(arrInt, 0, arrInt.length);
    }


}
