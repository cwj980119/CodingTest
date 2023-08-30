import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, min, start;
	static int[][] adj;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		adj = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = 10000000;
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			start = i;
			visited[i] = true;
			visit(1,0,i);
			visited[i] = false;
		}
		System.out.println(min);
	}
	
	static void visit(int d, int w_sum, int curr) {
		if(d == n) {
			if(adj[curr][start] != 0) {
				if(min > w_sum + adj[curr][start]) min = w_sum + adj[curr][start];				
			}
			return;
		}
		for(int i = 0; i < n; i++) {
			if(!visited[i] && adj[curr][i] != 0) {
				visited[i] = true;
				visit(d+1, w_sum + adj[curr][i], i);
				visited[i] = false;
			}
		}
	}
}