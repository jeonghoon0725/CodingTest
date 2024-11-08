import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner in  = new Scanner(System.in);
		
		int cnt = in.nextInt();
		
		while(cnt-- > 0) {
			//System.out.println(cnt);
			
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int r1 = in.nextInt();
			
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			int r2 = in.nextInt();
			
			System.out.println(calc(x1, y1, r1, x2, y2, r2));
		}
		
	}
	
	public static int calc(int x1, int y1, int r1, int x2, int y2, int r2) {
		//-1 동일
		if(x1 == x2 && y1 == y2 && r1 == r2) {
			return -1;
		} else {
			int distance_pow = (int)(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			
			//0-1 밖에
			if(distance_pow > (int)Math.pow(r1+r2, 2)) {
				return 0;
			//0-2 안에 쏙
			} else if(distance_pow < (int)Math.pow(r1-r2, 2)) {
				return 0;
			}
			//1-1 내접
			else if(distance_pow == (int)Math.pow(r1-r2, 2)) {
				return 1;
			//1-2 외접
			} else if(distance_pow == (int)Math.pow(r1+r2, 2)) {
				return 1;
			}
			//2 그외
			else return 2;
		}
	}
}