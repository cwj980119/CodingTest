import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int n;
	static int tbl[][];
	static int a[];
	static int b[];
	static boolean visited[];
	static int cnt;
	static int limit;
	static int diff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			tbl = new int[n][n];
			a = new int[n/2];
			b = new int[n/2];
			visited = new boolean[n];
			getLimit();
			for(int i = 0; i <n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<n;j++) {
					tbl[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			diff = 1999999999;
			combination(0, n/2);
			System.out.println("#" + t + " " + diff);
		}

		
		
		
	}
	
	static void combination(int start, int r) {
	    if(r == 0) {
	    	cnt++;
	    	int ac = 0;
	    	int bc = 0;
	    	for (int i = 0; i < n; i++) {
	            if (visited[i]) {
	            	a[ac++] = i;
	            }
	            else b[bc++] = i;
	        }
	    	int a_total = getTotal(a);
	    	int b_total = getTotal(b);
//	        for(int i = 0; i < n/2; i++) {
//	        	System.out.print(a[i]+" ");
//	        }
//	        System.out.println(a_total);
//	        for(int i = 0; i < n/2; i++) {
//	        	System.out.print(b[i]+" ");
//	        }
//	        System.out.println(b_total);
	        int d = a_total < b_total? b_total - a_total: a_total -b_total;
	        if(d < diff) diff = d;
	        return;
	    } 

	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(i + 1, r - 1);
	        if(cnt == limit) return;
	        visited[i] = false;
	    }
	}
	
	static int getTotal(int arr[]) {
		int total = 0;
		for(int i = 0; i<arr.length;i++) {
			for(int j = 0; j < arr.length;j++) {
				total += tbl[arr[i]][arr[j]];
			}
		}
		return total;
	}
	
	static void getLimit() {
		int a = n;
		int b = 1;
		int sum = 1;
		int div = 1;
		for(int i = 1; i <= n/2;i++) {
			sum *= a--;
			div *= b++;
		}
		limit = sum/(div*2);
	}

}