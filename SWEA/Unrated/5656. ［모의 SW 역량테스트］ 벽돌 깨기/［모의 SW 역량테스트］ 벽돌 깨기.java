import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, w, h;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			int[][] map = new int[h][w];
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			min = 99999999;
			for(int i = 0; i < w; i++) {
				shoot(1, i, map);				
			}
			sb.append("#"+t+" "+min+"\n");
			
		}
		System.out.println(sb);
	}
	
	public static void shoot(int d, int x, final int[][] map) {
		int[][] map_copy = new int[h][w];
		for(int i=0; i < h; i++) {
			for(int j = 0; j < w; j++) {
				map_copy[i][j] = map[i][j];
			}
		}
		Queue<Brick> q = new LinkedList<Brick>();
		for(int i = 0; i < h; i++) {
			if(map_copy[i][x] != 0) {
				q.add(new Brick(map_copy[i][x], i, x));
				map_copy[i][x] = 0;
				break;
			}
		}
		Brick curr;
		int nr, nc;
		while(!q.isEmpty()) {
			curr = q.poll();
			for(int i = 0; i < 4; i++) {
				for(int j = 1; j < curr.num; j++) {
					nr = curr.x + dx[i]*j;
					nc = curr.y + dy[i]*j;
					if(nr >= 0 && nr < h && nc >= 0 && nc < w &&map_copy[nr][nc] != 0) {
						if(map_copy[nr][nc] > 1) q.add(new Brick(map_copy[nr][nc], nr, nc));
						map_copy[nr][nc] = 0;
					}					
				}
			}
		}
		
		for(int i = 0; i < w; i++) {
line:		for(int j = h-1; j >= 0; j--) {
				if(map_copy[j][i] == 0) {
					for(int k = j-1; k >=0; k--) {
						if(map_copy[k][i]!=0) {
							map_copy[j][i] = map_copy[k][i];
							map_copy[k][i] = 0;
							break;
						}
						if(k == 0) break line;
					}
				}
			}
		}
		
//		System.out.println("======="+x+"------");
//		for(int i = 0; i < h; i++) {
//			for(int j = 0; j < w; j++) {
//				System.out.print(map_copy[i][j]+" ");
//			}
//			System.out.println();
//		}
		if(d == n) {
			int cnt = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(map_copy[i][j]!=0) cnt++;
				}
			}
			if(cnt < min) min = cnt;
			return;
		}
		boolean flag = false;
		for(int i = 0; i < w; i++) {
			if(map_copy[h-1][i] != 0) {
				flag = true;
				shoot(d+1, i, map_copy);
			}
		}
		if(!flag) min = 0;
	}
	
	static class Brick{
		int num;
		int x;
		int y;
		public Brick(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}

}