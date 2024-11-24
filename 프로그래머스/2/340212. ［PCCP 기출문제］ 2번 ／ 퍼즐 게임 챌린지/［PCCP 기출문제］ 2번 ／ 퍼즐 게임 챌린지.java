import java.util.Arrays;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
		int right = Arrays.stream(diffs).max().getAsInt();
		
		while(left < right) {
			int mid = (left + right) / 2;
			
			if(limit >= getTime(mid, diffs, times)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}
	
	private static long getTime(int level, int[] diffs, int[] times) {
		long time = 0;
		
		for(int i = 0; i < diffs.length; i++) {
			if(level >= diffs[i]) {
				time += times[i];
			} else {
				long mistakes = diffs[i] - level;
				long prevTime = i==0?0:times[i-1];
				time += mistakes * (prevTime + times[i]) + times[i];
			}
		}
		
		return time;
	}
}