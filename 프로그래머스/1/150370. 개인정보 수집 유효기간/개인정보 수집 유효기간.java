import java.util.HashMap;
import java.util.ArrayList;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<String, Integer> termsMap = new HashMap<String, Integer>();
		for(String term : terms) {
			termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
		}
		
		int year = Integer.parseInt(today.split("\\.")[0]);
		int month = Integer.parseInt(today.split("\\.")[1]);
		int day = Integer.parseInt(today.split("\\.")[2]);
		
		for(int i=0;i<privacies.length;i++) {
			String startDate = privacies[i].split(" ")[0];
			int term = termsMap.get(privacies[i].split(" ")[1]) *28;
			
			int calc = (year - Integer.parseInt(startDate.split("\\.")[0])) *28 *12
					+ (month - Integer.parseInt(startDate.split("\\.")[1])) *28
					+ (day - Integer.parseInt(startDate.split("\\.")[2]));
			
			if(calc >= term) {
				list.add(i+1);
			}
		}
		
		int[] answer = new int[list.size()];
		for(int i=0;i<list.size();i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
    }
}