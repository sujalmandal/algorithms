package algo;

import java.util.*;

/*
Your company built an in-house calendar tool called HiCal. You want to add a feature to see the times
 in a day when everyone is available.

To do this, you’ll need to know when any team is having a meeting.
In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
 These integers represent the number of 30-minute blocks past 9:00am.
 */
public class MergeMeetings {
    /* Write a method mergeRanges() that takes a list of multiple meeting time ranges
     * and returns a list of condensed ranges.
     */
    /*   [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]
     *   [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]
     */
    public static void main(String[] args) {
        /* the trick would be to sort the meeting by their starting time the processing
         * them in that order while finding out the overlaps between m1' end time and m2's start time
         */
        List<Meeting> meetings = new ArrayList<>(
                Arrays.asList(Meeting.of(0,1), Meeting.of(3,5), Meeting.of(4,8), Meeting.of(10,12), Meeting.of(9,10))
        );
        Collections.sort(meetings, Comparator.comparingInt(m -> m.startTime));
        System.out.println("Sorted meetings : "+meetings);
        if(meetings.size()>1){
            for(int firstIndex=0,secondIndex=1; secondIndex<meetings.size();){
                Meeting m1 = meetings.get(firstIndex);
                Meeting m2 = meetings.get(secondIndex);
                if(m1.overlapsWith(m2)){
                    Meeting m1m2Merged = Meeting.merge(m1,m2);
                    meetings.remove(firstIndex);
                    meetings.set(firstIndex,m1m2Merged);
                } else {
                    firstIndex++;
                    secondIndex++;
                }
            }
        }
        System.out.println(meetings);
    }

    public static class Meeting {

        private int startTime;
        private int endTime;

        public static Meeting of(int start,int end){
            Meeting meeting = new Meeting();
            meeting.startTime = start;
            meeting.endTime = end;
            return meeting;
        }

        public static Meeting merge(Meeting m1, Meeting m2){
            Meeting meeting = new Meeting();
            meeting.startTime = m1.startTime;
            meeting.endTime = Math.max(m1.endTime, m2.endTime);
            return meeting;
        }

        public boolean overlapsWith(Meeting other){
            return this.endTime >= other.startTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public String toString() {
            return "[start=" + startTime +",end=" + endTime +"]";
        }
    }
}

