import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int cave[][];
	public static boolean visited[][];
	public static int dx[] = {-1, 1, 0, 0};
	public static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 0;
		while(true) {
			tc++;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			cave = new int[n][n];
			visited = new boolean[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j ++){
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int k = cave[0][0];

			PriorityQueue<Rupee> pq = new PriorityQueue<>(new Comparator<Rupee>() {
				public int compare(Rupee a, Rupee b) {
					return a.cost < b.cost?-1:1;
				};
			});
			pq.add(new Rupee(k, 0, 0));
			Rupee curr;
			int nr, nc;
			while(!pq.isEmpty()) {
				curr = pq.poll();
				if(visited[curr.x][curr.y]) continue;
				if(curr.x == n-1 && curr.y == n-1) {
					k = curr.cost;
					break;
				}
				visited[curr.x][curr.y] = true;
				for(int i = 0; i < 4; i++) {
					nr = curr.x + dx[i];
					nc = curr.y + dy[i];
					if(nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
						pq.add(new Rupee(curr.cost + cave[nr][nc], nr, nc));
					}
				}
			}
			sb.append("Problem " + tc+": "+k+"\n");
			
		}
		System.out.println(sb);
	}
	
	static class Rupee{
		int cost;
		int x;
		int y;
		
		public Rupee(int cost, int x, int y) {
			this.cost  = cost;
			this.x = x;
			this.y = y;
		}
	}
}