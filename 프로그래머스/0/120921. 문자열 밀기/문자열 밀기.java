class Solution {
    public int solution(String A, String B) {
        for(int i = 0; i < A.length(); i++) {
			if(A.equals(B)) {
				return i;
			}
			
			String temp = A.substring(A.length()-1);
			
			A = temp + A.substring(0, A.length()-1);
		}
		return -1;
    }
}