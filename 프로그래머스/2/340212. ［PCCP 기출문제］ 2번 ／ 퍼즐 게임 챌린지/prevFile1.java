import java.util.Arrays;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 0;
		
		long limitRow;
		int time_prev;
		while(true) {
			level++;
			time_prev = 0;
			limitRow = limit;
			
			for(int i = 0; i < diffs.length; i++) {
				int diff = diffs[i];
				int time_cur = times[i];
				
				if(diff <= level) {
					limitRow -= time_cur;
				} else {
					limitRow -= time_cur + (diff - level) * time_prev + (diff - level) * time_cur;
				}
				
				time_prev = time_cur;
				
				if(limitRow < 0) {
					break;
				}
			}
			
			if(limitRow >= 0) {
				return level;
			}
		}
	}
}
