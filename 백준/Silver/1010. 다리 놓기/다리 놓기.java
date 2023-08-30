import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		int a, b;
		for(int i = 0; i< T; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			sb.append(""+combination(b,a)+"\n");
		}
		System.out.println(sb.toString());
	}

	public static int combination(int n, int r) {
		if(n <= r || r == 0) {
			dp[n][r] = 1;
			return 1; 
		}
		int a,b;
		if(dp[n-1][r-1] != 0) {
			a = dp[n-1][r-1];
		}
		else {
			a = combination(n-1,r-1);
			dp[n-1][r-1] = a;
		}
		if(dp[n-1][r] != 0) {
			b = dp[n-1][r];
		}
		else {
			b = combination(n-1,r);
			dp[n-1][r] = b;
		} 
		return a + b; 
	}

}