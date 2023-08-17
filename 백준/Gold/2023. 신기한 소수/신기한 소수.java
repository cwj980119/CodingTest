import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		for(int i = 1; i <= 9;i++) {
			recurrsion(i, 1);
		}
	}
	
	
	static void recurrsion(int num, int depth) {
		if(!check(num)) return;
		if(depth >= n) {
			System.out.println(num);
			return;
		}
		int curr = num*10;
		for(int i = 0; i <= 9; i++) {
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