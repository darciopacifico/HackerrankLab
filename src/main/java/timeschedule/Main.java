package timeschedule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import static java.lang.Math.max;
import static java.util.Collections.sort;
import static java.util.Comparator.comparingInt;

public class Main {

    public static void main(String[] args) {

        System.out.println(new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K'}, 7));

        System.out.println(new Solution().leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));

        //A
        //B
        //#
        //A
        //B
        //#
        //A
        //B

        /*
        A
        A
        A
        B
        B
        B
        C
        D
        E
        F
        G
        H
        I
        J
        K

      1  A
      2  B
      3  C
      4  D
      5  E
      6  F
      7  G
      8  H
      9  I
      0  J
     11  K
         A
         B
         #
         #
         #
         #
         #
         #
         #
         A
         B


        */

    }

    static class Solution {
        public int leastInterval(char[] tasks, int n) {

            Map<Character, Task> taskTypes = new HashMap<>();

            for (int i = 0; i < tasks.length; i++) {
                if (!taskTypes.containsKey(tasks[i])) {
                    taskTypes.put(tasks[i], new Task(tasks[i]));
                }
                taskTypes.get(tasks[i]).count++;
            }


            return 0;

        }

        class Task {
            public char taskType;
            public int count;

            public Task(char taskType) {
                this.taskType = taskType;
            }
        }

    }
}
