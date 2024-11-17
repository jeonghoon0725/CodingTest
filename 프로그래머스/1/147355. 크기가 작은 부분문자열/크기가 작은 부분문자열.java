class Solution {
    public int solution(String t, String p) {
        int answer = 0;
		int cnt = t.length() - p.length() + 1;//경우의 수
		Long pNum = Long.parseLong(p);//19자리
		
		for(int i = 0; i < cnt; i++) {
			String temp = t.substring(i, i + p.length());
			if(Long.parseLong(temp) <= pNum) {
				answer++;
			}
		}
		
		return answer;
    }
}