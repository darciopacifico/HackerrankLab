package minmeetingroom;

import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minMeetingRooms(
                new int[][]{
                        new int[]{1, 14},
                        new int[]{13, 15}
                }
        ));
    }

    public enum EventType {
        END, START
    }

    public class MeetingEvent {
        public int meetingId;
        public EventType eventType;
        public int time;

        public int getMeetingId() {
            return meetingId;
        }

        public EventType getEventType() {
            return eventType;
        }

        public int getTime() {
            return time;
        }

        public MeetingEvent(int meetingId, EventType eventType, int time) {
            this.meetingId = meetingId;
            this.eventType = eventType;
            this.time = time;
        }
    }

    public int minMeetingRooms(int[][] intervals) {

        ArrayList<MeetingEvent> meetingEvents = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            meetingEvents.add(new MeetingEvent(i, EventType.START, intervals[i][0]));
            meetingEvents.add(new MeetingEvent(i, EventType.END, intervals[i][1]));
        }

        meetingEvents.sort((o1, o2) -> {
            int comp = Integer.compare(o1.time, o2.time);

            if (comp == 0) {

                return o1.eventType.compareTo(o2.eventType);
            }

            return comp;
        });

        int maxSimultaneousMeetings = 0;
        int currSM = 0;
        for (MeetingEvent meetingEvent : meetingEvents) {

            if (meetingEvent.eventType == EventType.START) {
                currSM++;
            } else {
                currSM--;
            }

            maxSimultaneousMeetings = Math.max(maxSimultaneousMeetings, currSM);
        }

        return maxSimultaneousMeetings;
    }
}
