import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n , m, a, b;
	static boolean[] visited;
	static ArrayList<Integer>[] rel;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		rel = new ArrayList[n];
		visited = new boolean[n];
		for(int i = 0; i<n;i++) {
			rel[i] = new ArrayList<>();
		}
		for(int i = 0; i < m;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			rel[a].add(b);
			rel[b].add(a);
		}
		for(int i = 0; i < n;i++) {
			visited[i] = true;
			dfs(i, 1);
			if(flag) break;
		}
		if(flag) System.out.println(1);
		else System.out.println(0);
	}
	
	static void dfs(int id, int depth) {
		if(depth == 5) {
			flag = true;
			return;
		}
		visited[id] = true;
		for (Integer next : rel[id]) {
			if(!visited[next]) {
				dfs(next, depth+1);
				if(flag) return;
			}
		}
		visited[id] = false;
	}
}