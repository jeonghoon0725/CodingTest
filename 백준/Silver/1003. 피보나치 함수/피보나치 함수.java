import java.util.Scanner;

public class Main {
    
	static Integer[][] dp = new Integer[41][2];
	
	public static void main(String[] args) {
    	dp_init();
		Scanner in  = new Scanner(System.in);
		
		int T = in.nextInt();
		
		//StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			int N = in.nextInt();
			
			fibonacci(N);
			
			System.out.println(dp[N][0] + " " + dp[N][1]);
			
//			sb.append(dp[N][0] + " " + dp[N][1]);
//			sb.append("\n");
		}
		//System.out.println(sb);
	}
	
	public static void dp_init() {
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;
	}
	
    public static Integer[] fibonacci(int N) {
    	if(dp[N][0] == null || dp[N][1] == null) {
    		dp[N][0] = fibonacci(N-1)[0] + fibonacci(N-2)[0];
    		dp[N][1] = fibonacci(N-1)[1] + fibonacci(N-2)[1];
    	}
    	
    	return dp[N];
    }
    
}