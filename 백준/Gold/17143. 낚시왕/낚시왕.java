import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, m, total;
	static int[][] sea;
	static Shark[] sharks;
	static boolean[] isMoved;
	static int[] dx = {0, -1, 1, 0, 0};
	static int[] dy = {0, 0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sea = new int[r+2][c+2];
		sharks = new Shark[m + 1];
		int sr, sc, s, d,z;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			sharks[i + 1] = new Shark(new Point(sr, sc), s, d, z, i + 1);
			sea[sr][sc] = i + 1;
		}
		total = 0;
		for(int p = 1; p <= c; p++) {
//			System.out.println(p);
//			printSea();
			Catch(p);
			resetSea();
			moveSharks();
		}
		System.out.println(total);
	}
	
	static void Catch(int p) {
		for(int i = 1; i <= r; i++) {
			if(sea[i][p] != 0 && !sharks[sea[i][p]].isCatched) {
				total += sharks[sea[i][p]].size;
				sharks[sea[i][p]].isCatched = true;
				sea[i][p] = 0;
				return;
			}
		}
	}
	
	static void moveSharks() {
		isMoved = new boolean[m + 1];
		for(int i = 1; i <= m; i++) {
			
		}
		for(int i = 1; i <= m; i++) {
			if(!sharks[i].isCatched) swim(sharks[i]);
		}
	}
	
	static void swim(Shark curr) {
		int nr = curr.pos.x, nc = curr.pos.y;
		int dr = nr, dc = nc;
		int dir = curr.dir;
		for(int i = 0; i < curr.speed; i++) {
			if(dr + dx[dir] <= 0) dir = 2;
			if(dr + dx[dir] > r) dir = 1;
			if(dc + dy[dir] <= 0) dir = 3;
			if(dc + dy[dir] > c) dir = 4;
			dr += dx[dir];
			dc += dy[dir];
		}
		curr.dir = dir;
		curr.pos.x = dr;
		curr.pos.y = dc;
		if(sea[dr][dc] == 0) {
			sea[dr][dc] = curr.idx;
		}
		else if(sharks[sea[dr][dc]].isCatched || sharks[sea[dr][dc]].size < curr.size){
			sharks[sea[dr][dc]].isCatched = true;
			sea[dr][dc] = curr.idx;			
		}
		else if(sharks[sea[dr][dc]].size > curr.size) {
			curr.isCatched = true;
		}

	}
	
	static void resetSea() {
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <=c ;j++) {
				sea[i][j] = 0;
			}
		}
	}
	
//	static void printSea() {
//		for(int i = 1; i <= r; i++) {
//			for(int j = 1; j <=c ;j++) {
//				if(sea[i][j] != 0) System.out.print(sharks[sea[i][j]].size+"\t");
//				else System.out.print(0 + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	
	static class Shark{
		Point pos;
		int speed, dir, size, idx;
		boolean isCatched;
		
		public Shark(Point pos, int s, int d, int z, int idx) {
			this.pos = pos;
			this.speed = s;
			this.dir = d;
			this.size = z;
			this.idx = idx;
			this.isCatched = false;
		}
		
		public Shark() {
			this.size = 0;
		}
		
		@Override
		public String toString() {
			
			return ""+ size;
		}
	}

}