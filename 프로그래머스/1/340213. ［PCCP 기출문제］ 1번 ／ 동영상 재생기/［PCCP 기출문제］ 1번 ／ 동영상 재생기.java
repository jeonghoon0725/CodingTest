class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int len_s = toSeconds(video_len);
        int pos_s = toSeconds(pos);
		int op_s_s = toSeconds(op_start);
		int op_e_s = toSeconds(op_end);
		
		//opening check
		if(pos_s >= op_s_s && pos_s < op_e_s) {
			pos_s = op_e_s;
		}
		
		//while command
		for(String command : commands) {
			if(command.equals("prev")) {//-10 min 0
				//pos_s = pos_s-10<0?0:pos_s-10;
				pos_s = Math.max(pos_s-10, 0);
			} else {//next +10 max len_s
				//pos_s = pos_s+10>len_s?len_s:pos_s+10;
				pos_s = Math.min(pos_s+10, len_s);
			}
			
			//opening check
			if(pos_s >= op_s_s && pos_s < op_e_s) {
				pos_s = op_e_s;
			}
		}
		System.out.println(pos_s);
		
		String mm = String.format("%02d", (int) Math.floor((double) pos_s/60));
		String ss = String.format("%02d", pos_s%60);
        String answer = mm + ":" + ss;
        
        return answer;
    }
    
    private static int toSeconds(String time) {
		String[] time_ms = time.split(":");
		return Integer.parseInt(time_ms[0])*60 + Integer.parseInt(time_ms[1]);
	}
}