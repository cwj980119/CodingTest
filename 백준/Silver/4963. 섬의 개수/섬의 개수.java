import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] field;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int h,w;
		while(true) {	
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(h == 0 && w == 0) break;
			field = new int[h+2][w+2];
			visited = new boolean[h+2][w+2];
			for(int i = 0; i <= h+1; i++) {
				for(int j = 0; j<=w+1;j++) {
					field[i][j] = -1;
				}
			}
			for(int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j <=w; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for(int i = 1; i<=h;i++) {
				for(int j = 1; j<=w;j++) {
					if(field[i][j] == 1) {
						cnt++;
						BFS(i,j);
					}
				}
			}
			bw.write(""+cnt+'\n');
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void BFS(int i, int j) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(i,j));
		int[] dirX = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] dirY = {-1,  0, 1, -1, 1,-1, 0, 1};
		visited[i][j] = true;
		int nx, ny;
		Point curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			for(int k = 0; k < 8; k++) {
				nx = curr.x + dirX[k];
				ny = curr.y + dirY[k];
				if(field[nx][ny] == 1) {
					q.add(new Point(nx,ny));
					field[nx][ny] = 0;
				}
			}
		}
	}

}