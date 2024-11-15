class Solution {
    public int solution(int[] wallet, int[] bill) {
        //1. 지폐를 접은 횟수를 저장할 정수 변수 answer를 만들고 0을 저장합니다.
		int answer = 0;
		
		//2. 반복문을 이용해 bill의 작은 값이 wallet의 작은 값 보다 크거나 bill의 큰 값이 wallet의 큰 값 보다 큰 동안 아래 과정을 반복합니다.
		while(max(wallet) < max(bill) || min(wallet) < min(bill)) {
			if(bill[0] > bill[1]) { //2-1. bill[0]이 bill[1]보다 크다면 
				bill[0] = (int) Math.floor(bill[0]/2); //bill[0]을 2로 나누고 나머지는 버립니다.
			} else { //2-2. 그렇지 않다면
				bill[1] = (int) Math.floor(bill[1]/2); //bill[1]을 2로 나누고 나머지는 버립니다.
			}
			
			answer += 1; //2-3. answer을 1 증가시킵니다.
		}
		
        //3. answer을 return합니다.
		return answer;
    }
    
    private static int max(int[] arr) {
        return Math.max(arr[0], arr[1]);
    }

    private static int min(int[] arr) {
        return Math.min(arr[0], arr[1]);
    }
}