package timeschedule;

import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        //['A','A','B','C','D','E','F','G','H','I','J','K','L','M','N',O','P','Q','R','S','T','U','V','W','X','Y','Z']
        //29
        //Expected Output: 31
        //Actual Output: 32

        System.out.println(new Solution().leastInterval(new char[]{
                'A', 'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G',
        }, 2));

        System.out.println(new Solution().leastInterval(new char[]{
                'A', 'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F'
        }, 2));


    }

    static class Solution {

        public int leastInterval(char[] tasks, int n) {



            int x = 2 >> 2;

            if (n == 0) return tasks.length;
            int[] freq = new int[26];

            for (int i = 0; i < tasks.length; i++) {
                freq[tasks[i] - 'A']++;
            }

            sort(freq);
            int max_freq = freq[freq.length - 1];

            int tasksWithSameMaxCount = 0;
            for (int i = freq.length - 1; i >= 0; i--) {
                if (freq[i] == max_freq) tasksWithSameMaxCount++;
            }

            final int groupSize = 1 + n; // the element itself + the cool down spaces

            final int groupCountMinusLastOne = max_freq - 1;

            int totalSlots = (groupCountMinusLastOne * groupSize) + tasksWithSameMaxCount;

            return Math.max(tasks.length, totalSlots);
        }
    }
}
