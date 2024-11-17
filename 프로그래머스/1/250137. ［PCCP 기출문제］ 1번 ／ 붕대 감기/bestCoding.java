public class Solution {
	
	public static void main(String[] args) {
		
		int[] bandage = {5, 1, 5};
		int health = 30;
		int[][] attacks = {{2, 10}, {9, 15}, {10,5}, {11,5}};
		
		System.out.println(solution(bandage, health, attacks));
		
	}
	
	public static int solution(int[] bandage, int health, int[][] attacks) {
		int cnt = bandage[0];//추가 체력 기준
		int now = health;//현재 체력
		int std = 0;//마지막으로 공격당한 시간
		
		//추가 체력 받을 수 있는지
		int v1, v2;
		
		for(int[] attack : attacks) {
			if(now <= 0) {
				return -1;
			}
			
			v1 = attack[0] - std - 1;//지금 공격당한 시간과 마지막으로 공격당한 시간 차이
			System.out.println(attack[0]);
			System.out.println(std);
			
			
			v2 = v1 / cnt;//추가 체력 받을 수 있는지
			
			//맞기 직전까지 체력 정산
			std = attack[0];
			now = Math.min(health, now + (v1*bandage[1]));
			now = Math.min(health, now + (v2*bandage[2]));
			
			//맞기
			now -= attack[1];
		}
		
		return now <= 0 ? -1 : now;
	}
}
