class Solution {
	public String solution(String s) {
		String[] arrStr = s.split(" ");
		int[] arrInt = new int[arrStr.length];
		
		for(int i = 0; i < arrStr.length; i++){
			arrInt[i] = Integer.parseInt(arrStr[i]);
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(Arrays.stream(arrInt).min().getAsInt());
		sb.append(" ");
		sb.append(Arrays.stream(arrInt).max().getAsInt());
		
		return sb.toString();
	}
}
