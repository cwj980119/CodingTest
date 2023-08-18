import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	static int n, m, v;
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws Exception {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n+1];
		for(int i = 1; i<= n;i++) {
			graph[i] = new ArrayList<>();
		}
		int a, b;
		
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i = 1; i<=n;i++) {
			graph[i].sort(null);
		}
		visited = new boolean[n+1];
		visited[v] = true;
		dfs(v);
		bw.write('\n');
		visited = new boolean[n+1];
		bfs(v);
		
		
		bw.flush();
		br.close();
		bw.close();
		
	}
	static void dfs(int s) throws Exception {
		bw.write(s + " ");
		for (int child : graph[s]) {
			if(!visited[child]) {
				visited[child] = true;
				dfs(child);
			}
		}
	}
	
	static void bfs(int s) throws Exception {
		Queue<Integer> q = new LinkedList<>();
		visited[s] = true;
		q.add(s);
		int curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			bw.write(curr + " ");
			for(int child : graph[curr]) {
				if(!visited[child]) {
					visited[child] = true;
					q.add(child);
				}
			}
		}
		
	}

}