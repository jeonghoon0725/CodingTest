class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
		
		int total = sequence.length;
		int sum = 0;
		int range = total;
		int min = 0;
		for(int left = 0, right = 0; right < total; right++) {
			sum += sequence[right];
			
			while(sum > k) {
				sum -= sequence[left];
				left++;
			}
			
			if(sum == k) {
				if(range >= right - left + 1) {
					if(range == right - left + 1) {
						if(min < left) {
							continue;
						}
					}
					min = left;
					range = right - left + 1;
					answer[0] = left;
					answer[1] = right;
				}
			}
		}
		
		return answer;
    }
}