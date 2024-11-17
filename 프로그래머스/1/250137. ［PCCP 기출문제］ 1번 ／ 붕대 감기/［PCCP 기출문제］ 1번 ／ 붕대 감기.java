import java.util.HashMap;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
		
		int ss = 0;
		int endTime = 0;
		int maxHealth = health;
		int successCnt = 0;
		HashMap<Integer, Integer> attacksMap = new HashMap<Integer, Integer>();
		for(int[] attack : attacks) {
			attacksMap.put(attack[0], attack[1]);
			endTime = attack[0];
		}
		
		while(ss++ < endTime) {
			if(attacksMap.containsKey(ss)) {
				health -= attacksMap.get(ss);
				successCnt = 0;
			} else {
				health += bandage[1];
				successCnt++;
				
				if(successCnt == bandage[0]) {
					health += bandage[2];
					successCnt = 0;
				}
				
				if(health > maxHealth) {
					health = maxHealth;
				}
			}
			
			if(health <= 0) {
				return -1;
			}
		}
		
		answer = health;
		
		return answer;
    }
}