import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] field, answer, tag;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		field = new int[n][m];
		answer = new int[n][m];
		tag = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				field[i][j] = s.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && field[i][j] == 0) {
					BFS(i, j);
				}
			}
		}

		int nr, nc;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(field[i][j] == 1) {
					for(int k = 0; k < 4; k++) {
						nr = i + dx[k];
						nc = j + dy[k];
						if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
							field[i][j] += answer[nr][nc];
						}
					}
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				sb.append(String.valueOf(field[i][j]%10));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void BFS(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> al = new ArrayList<>();
		visited[r][c] = true;
		q.add(new Point(r,c));
		Point curr;
		int nr, nc;
		int cnt = 0;
		while(!q.isEmpty()) {
			curr = q.poll();
			cnt++;
			for(int i = 0; i < 4; i++) {
				nr = curr.x + dx[i];
				nc = curr.y + dy[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
					visited[nr][nc] = true;
					if(field[nr][nc] == 0) {						
						q.add(new Point(nr, nc));
					}
					else if(field[nr][nc] != 0) {
						al.add(new Point(nr,nc));
					}
				}
			}
		}
		for (Point p : al) {
			field[p.x][p.y] += cnt;
			visited[p.x][p.y] = false;
		}
	}
	

}