class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String target = board[h][w];
		
		int[] x = {0 ,0 ,1 ,-1};
		int[] y = {-1 ,1 ,0 ,0};
		
		for(int i = 0; i < x.length; i++) {
			int hi = h + x[i];
			int wi = w + y[i];
			
			if(hi >= 0 && hi < board.length && wi >= 0 && wi < board.length) {
				if(target.equals(board[hi][wi])) {
					answer++;
				}
			}
		}
        
        return answer;
    }
}