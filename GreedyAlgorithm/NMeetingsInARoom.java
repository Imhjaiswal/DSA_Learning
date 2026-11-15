package GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NMeetingsInARoom {
    // OPTIMAL
    // T.C. - O(2N) + O(N*logN)
    // S.C. - O(2N)
    List<Integer> maximizeMeetings (int[]start, int[]end) {
        List<Integer> position = new ArrayList<>();

        if (start == null || end == null || start.length == 0 || end.length == 0) return position;
        
        // STORE START, END, POSITION IN A DATA STRUCTURE
        MeetingDetails [] meetings = new MeetingDetails[start.length];

        for (int i=0; i<start.length; i++) {
            meetings[i] = new MeetingDetails(start[i], end[i], i+1);
        }

        // SORT ACCORDING TO END TIME
        Arrays.sort(meetings, (a,b) -> Integer.compare(a.endTime, b.endTime));

        // MAXIMIZE & STORE THE MEETINGS
        int count = 1;
        int FreeTime = meetings[0].endTime;

        for (int i=1; i<meetings.length; i++) {
            if (meetings[i].startTime > FreeTime) {
                count++;
                FreeTime = meetings[i].endTime;
                position.add(meetings[i].index);
            }
        }
        return position; //COUNT if need to return total no of jobs completed
    }
}

class MeetingDetails {
    int startTime;
    int endTime;
    int index;

    MeetingDetails (int startTime, int endTime, int index) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.index = index;
    }
}