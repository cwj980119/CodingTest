import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] field;
	static int []dx = {-1, 1, 0, 0};
	static int []dy = {0, 0, -1, 1};
	static int[][] minDist;
	static boolean[][] visited;
	static int[] parent;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				field[i][j] = -Integer.parseInt(st.nextToken());
			}
		}
		int num = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(field[i][j] == -1) {
					checkIsland(i, j, num++);
				}
			}
		}
		
		minDist = new int[num][num];
		for(int i = 0; i<num;i++) {
			for(int j = 0; j <num;j++) {
				minDist[i][j] = 100;
			}
		}
		
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(field[i][j] != 0 && ! visited[i][j]) {
					checkDistance(i,j);
				}
			}
		}
		
		pq = new PriorityQueue<>();
		for(int i = 1; i < num; i++) {
			for(int j = i+1; j < num; j++) {
				if(minDist[i][j] != 100) {
					pq.add(new Edge(minDist[i][j], i,j));
				}
			}
		}
		
		parent = new int[num];
		for(int i = 1; i< num;i++) {
			parent[i] = i;
		}
		
		Edge e;
		int sum = 0;
		while(!pq.isEmpty()) {
			if(num == 2) {
				break;
			}
			e = pq.poll();
			if(union(e.r, e.c)) {
				num--;
				sum += e.distance;
			}
		}
		if(num != 2) sum = -1;
		System.out.println(sum);
	}
	
	static class Edge implements Comparable<Edge>{
		int distance;
		int r;
		int c;
		Edge(int d, int r, int c){
			this.distance = d;
			this.r = r;
			this.c = c;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.distance - o.distance;
		}
	}
	
	static void checkDistance(int r, int c) {
		int nr, nc;
		visited[r][c] = true; 
		for(int i = 0; i<4;i++) {
			nr = r + dx[i];
			nc = c + dy[i];
			if(nr >= 0 && nr < n && nc >= 0 && nc < m) {				
				if(field[nr][nc] == field[r][c] && !visited[nr][nc]) {
					checkDistance(nr, nc);
				}
				else if(field[nr][nc] != field[r][c]) {
					getDistance(field[r][c], nr, nc, i);
				}
			}
		}
	}
	
	static void getDistance(int cur, int nr, int nc, int i) {
		int cnt = 1;
		while(true) {
			nr += dx[i];
			nc += dy[i];
			if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if(field[nr][nc] == 0) {
					cnt++;
					continue;
				}
				else if(cnt >= 2) {
					minDist[cur][field[nr][nc]] = (int)Math.min(minDist[cur][field[nr][nc]], cnt);		
					return;
				}
				return;
			}
			else return;
		}
	}
	
	static void checkIsland(int r, int c, int num) {
		field[r][c] = num;
		int nr, nc;
		for(int i = 0; i<4;i++) {
			nr = r + dx[i];
			nc = c + dy[i];
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && field[nr][nc] == -1) {
				checkIsland(nr, nc, num);
			}
		}
	}
	
	static boolean union(int i, int j) {
		int pa = findParent(i);
		int pb = findParent(j);
		if(pa != pb) {
			parent[pb] = pa;
			return true;
		}
		else return false;
	}
	
	static int findParent(int i) {
		if(parent[i] == i) return i;
		return parent[i] = findParent(parent[i]);
	}

}