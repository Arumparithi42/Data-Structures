import java.util.Arrays;
import java.util.PriorityQueue;
public class MeetingRooms2 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // 1. Sort the meetings based on their START times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // 2. Min-Heap to track the end times of active meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add the end time of the first meeting
        minHeap.add(intervals[0][1]);

        // 3. Iterate through the rest of the meetings
        for (int i = 1; i < intervals.length; i++) {
            // If the room with the earliest end time is free, reuse it
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.poll();
            }

            // Allocate a room (adds the current meeting's end time to the heap)
            minHeap.add(intervals[i][1]);
        }

        // The size of the heap represents the minimum rooms required
        return minHeap.size();
    }
}
