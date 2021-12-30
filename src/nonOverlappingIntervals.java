import java.util.Arrays;
import java.util.Comparator;

public class nonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int count=1;
        int k=0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=intervals[k][1]){
                count++;
                k=i;
            }
        }
        return intervals.length-count;
    }
}

