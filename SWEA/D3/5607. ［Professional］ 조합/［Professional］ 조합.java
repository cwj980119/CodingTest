import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static long[] factorial = new long[1000001];
	static long MOD = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		int n, r;
		init();
		
		for(int t = 1; t <=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			long np = factorial[n];
			long rp = factorial[n-r] * factorial[r] % MOD;
			long rps = pow(rp, MOD-2);
			sb.append("#"+t+" "+((np*rps)%MOD)+"\n");
		}
		System.out.println(sb);

	}
	
	static long pow(long rp, long s) {
		
		if(s == 1) {
			return rp;
		}
		long half = pow(rp, s/2) % MOD;
		if(s%2==1) {
			return ((half * half) % MOD * rp) % MOD;
		}
		else {
			return (half * half) % MOD;
		}
	}
	
	static void init() {
		factorial[1] = 1;
		for(int i = 2; i < 1000001;i++) {
			factorial[i] = factorial[i-1]*i%MOD;
		}
	}

}