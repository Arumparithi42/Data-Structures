import java.util.*;
public class MergeInterval {
    public int[][] insert(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        
        int[] curr = intervals[0];
        for(int i = 1; i < intervals.length; i++){
            int currEnd = curr[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (currEnd >= nextStart){
                currEnd = Math.max(currEnd, nextEnd);
            }
            else{
                ans.add(curr);
                curr = intervals[i];
            }
        }
        ans.add(curr);
        return ans.toArray(new int[ans.size()][2]);
    }
}