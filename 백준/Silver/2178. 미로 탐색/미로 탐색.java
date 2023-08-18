import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] field;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		field = new int[n+2][m+2];
		visited = new boolean[n+2][m+2];
		
		String str;
		for(int i = 1; i <= n; i++) {
			str = br.readLine();
			for(int j = 1; j <= m; j++) {
				field[i][j] = str.charAt(j-1) - '0';
			}
		}

		System.out.println(bfs());
		
	}
	
	static class Node{
		int x;
		int y;
		int cnt;
		public Node(int a, int b, int c) {
			this.x = a;
			this.y = b;
			this.cnt = c;
		}
	}
	
	static int bfs() {
		Queue<Node> q = new LinkedList<>();
		Node curr;
		int[] dirX = {1, 0, -1, 0};
		int[] dirY = {0, 1, 0, -1};
		int nr,nc;
		q.add(new Node(1,1,1));
		visited[1][1] = true;
		while(!q.isEmpty()) {
			curr = q.poll();
			if(curr.x == n && curr.y == m) {
				return curr.cnt;
			}
			for(int i = 0; i<4;i++) {
				nr = curr.x + dirX[i];
				nc = curr.y + dirY[i];
				if(field[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new Node(nr,nc,curr.cnt+1));
				}
			}
		}
		
		return 0;
	}

}