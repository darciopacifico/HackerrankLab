package arraybinarysearch;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int arraySize = Integer.MAX_VALUE - 100000;

        int[] array = new int[arraySize];

        int y = 0;
        for (int j = arraySize - 1000; j < arraySize; j++) {
            array[j] = y++;
        }

        int res = Arrays.binarySearch(array, 123);

        System.out.println(res);
        System.out.println( array[res]);


    }


}
