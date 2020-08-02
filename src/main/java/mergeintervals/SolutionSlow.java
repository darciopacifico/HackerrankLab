package mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SolutionSlow {

    public static void main(String[] args) {
        Arrays.asList(

                new SolutionSlow().merge(new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 6},
                        new int[]{8, 10},
                        new int[]{15, 18}
                })
        ).forEach(arrInterval -> System.out.println(arrInterval[0] + "-" + arrInterval[1]));
    }


    private static class IntervalEvent {
        public int timestamp;
        public char type;

        public IntervalEvent(int timestamp, char type) {
            this.timestamp = timestamp;
            this.type = type;
        }
    }

    public int[][] merge(int[][] intervals) {


        List<IntervalEvent> intervalEvents = getSortedIntervalEvents(intervals);

        LinkedList<int[]> mergedIntervals = new LinkedList<>();
        int[] currentInterval = null;
        int openedIntervalCount = 0;
        for (IntervalEvent ie : intervalEvents) {
            if (ie.type == 's') {

                openedIntervalCount++;
                if (currentInterval == null) {
                    currentInterval = new int[]{ie.timestamp, -1};
                }

            } else {
                openedIntervalCount--;

                if (openedIntervalCount == 0) {
                    //end of an interval overlap
                    currentInterval[1] = ie.timestamp;
                    mergedIntervals.add(currentInterval);
                    currentInterval = null;
                }
            }
        }


        return getResultAsArray(mergedIntervals);
    }

    private List<IntervalEvent> getSortedIntervalEvents(int[][] intervals) {

        List<IntervalEvent> intervalEvents = new ArrayList<>(intervals.length * 2);

        for (int[] interval : intervals) {
            intervalEvents.add(new IntervalEvent(interval[0], 's'));
            intervalEvents.add(new IntervalEvent(interval[1], 'e'));
        }

        intervalEvents.sort((ie1, ie2) -> {
            if (ie1.timestamp != ie2.timestamp) {
                return ie1.timestamp - ie2.timestamp;
            } else {
                return -(ie1.type - ie2.type);
            }
        });

        return intervalEvents;
    }

    private int[][] getResultAsArray(LinkedList<int[]> mergedIntervals) {
        int[][] resultAsArray = new int[mergedIntervals.size()][];

        int i = 0;
        for (int[] mergedInterval : mergedIntervals) {
            resultAsArray[i++] = mergedInterval;
        }
        return resultAsArray;
    }
}
