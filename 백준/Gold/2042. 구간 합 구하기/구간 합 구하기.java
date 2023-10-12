import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long[] arr;
	static long[] tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int m, k;
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new long[n+1];
		tree = new long[n+1];
		
		for(int i = 1; i < n+1; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		for(int i = 1; i < n+1; i++) {
			int curr = i;
			long num = arr[curr];
			while(curr < n+1) {
				tree[curr] += num;
				curr += (curr&-curr);
			}
		}
		
		int a;
		long b, c;
		for(int t = 0; t < m+k; t++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Long.parseLong(st.nextToken());
			c = Long.parseLong(st.nextToken());
			if(a == 1) {
				int curr = (int)b;
				long num = arr[curr];
                arr[curr] = c;
				while(curr < n+1) {
					tree[curr] += (c-num);
					curr += (curr&-curr);
				}
			}
			else {
				long bsum = 0, csum = 0;
				int curr = (int)b-1;
				while(curr > 0) {
					bsum += tree[curr];
					curr -= (curr&-curr);
				}
				curr = (int)c;
				while(curr > 0) {
					csum += tree[curr];
					curr -= (curr&-curr);
				}
				sb.append(csum-bsum + "\n");
			}
			
		}
		System.out.println(sb);
		
	}
	
}