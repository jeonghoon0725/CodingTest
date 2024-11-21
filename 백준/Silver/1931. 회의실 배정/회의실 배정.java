import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		int[][] time = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			time[i][0] = in.nextInt();	// 시작시간 
			time[i][1] = in.nextInt();	// 종료시간
		}
		
		Arrays.sort(time, (o1, o2)->{
			if(o1[1] == o2[1]) {
				return o1[0]-o2[0];
			}
			return o1[1]-o2[1];
		});
		
		int before = 0;
		int result = 0;
		for(int i = 0; i < time.length; i++) {
			if(before <= time[i][0]) {
				before = time[i][1];
				result++;
			}
		}
		
		System.out.println(result);
	}
}