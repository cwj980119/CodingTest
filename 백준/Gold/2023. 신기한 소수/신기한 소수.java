import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		recurrsion(2,1);
		for(int i = 3; i <= 9;i+=2) {
			if(check(i)) recurrsion(i, 1);
		}
	}
	
	
	static void recurrsion(int num, int depth) {
		if(depth >= n) {
			System.out.println(num);
			return;
		}
		int curr = num*10;
		for(int i = 1; i <= 9; i+=2) {
			if(!check(curr + i)) continue;
			recurrsion(curr + i, depth+1);
		}
	}
	
	
	static boolean check(int n) {
		if(n==1) return false;
		if(n==2 || n==3) return true;
		for(int i = 2;i*i <= n;i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
	}
}