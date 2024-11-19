import java.util.HashMap;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
		
		HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
		for(int i=0;i<name.length;i++) {
			nameMap.put(name[i], yearning[i]);
		}
		
		for(int i=0;i<photo.length;i++) {
			int score = 0;
			for(String photoName : photo[i]) {
				if(nameMap.containsKey(photoName)) {
					score += nameMap.get(photoName);
				}
			}
			answer[i] = score;
		}
		
		return answer;
    }
}