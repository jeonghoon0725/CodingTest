import java.util.HashMap;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<players.length;i++) {
			map.put(players[i], i);
		}
		
		for(String calling : callings) {
			int calledPlayerRank = map.get(calling);
			
			map.put(players[calledPlayerRank-1], calledPlayerRank);
			map.put(players[calledPlayerRank], calledPlayerRank-1);
			
			String tmp = players[calledPlayerRank];
			players[calledPlayerRank] = players[calledPlayerRank-1];
			players[calledPlayerRank-1] = tmp;
		}
		answer = players; 
		
		return answer;
    }
}