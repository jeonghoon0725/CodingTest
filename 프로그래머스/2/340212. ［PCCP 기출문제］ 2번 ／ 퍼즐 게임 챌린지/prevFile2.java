import java.util.Arrays;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 0;
		
		int maxValue = Arrays.stream(diffs).max().getAsInt();
		int minValue = 1;
		
		while(minValue <= maxValue) {
			level = (maxValue + minValue) / 2;
			
			long result = game(level, diffs, times);
			
			if(limit == result) {
				return level;
			} else if(limit > result) {
				long nextResult = game(level-1, diffs, times);
				
				if(limit < nextResult || level == 1) {
					return level;
				} else {
					maxValue = level - 1;
				}
			} else if(limit < result) {
				minValue = level + 1;
			}
		}
		
		return -1;
	}
	
	private static long game(int level, int[] diffs, int[] times) {
		long time = 0;
		
		for(int i = 0; i < diffs.length; i++) {
			int diff = diffs[i];
			int time_cur = times[i];
			int time_prev = i==0?0:times[i-1];
			
			if(diff <= level) {
				time += time_cur;
			} else {
				time += time_cur + (diff - level) * (time_prev + time_cur);
			}
		}
		
		return time;
	}
}
