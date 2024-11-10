class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
		
		String[] validWords = {"aya", "ye", "woo", "ma"};
		
		for(String testWord : babbling) {
			for(String validWord : validWords) {
				if(testWord.contains(validWord)) {
					testWord = testWord.replace(validWord, "-");
				}
			}
			if(testWord.replace("-", "").equals("")) {
				answer++;
			}
		}
		
        return answer;
    }
}