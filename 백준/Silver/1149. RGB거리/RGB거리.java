import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int cost[][] = new int[n][3];
		int dp[][] = new int[n][3];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < 3; i++) {
			dp[0][i] = cost[0][i];
		}
		
		for(int i = 1; i < n; i++) {
				dp[i][0] = cost[i][0] + min(dp[i-1][1], dp[i-1][2]);
				dp[i][1] = cost[i][1] + min(dp[i-1][0], dp[i-1][2]);
				dp[i][2] = cost[i][2] + min(dp[i-1][0], dp[i-1][1]);
		}
		System.out.println(min(dp[n-1][0], min(dp[n-1][1], dp[n-1][2])));
		
	}
	
	static int min(int a, int b) {
		if(a < b) return a;
		else return b;
	}

}