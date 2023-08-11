import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1873 {

	static int h, w, n;
	static int tx, ty;
	static int dx[] = { -1, 1, 0, 0};
	static int dy[] = { 0, 0, -1, 1};
	static int dir;
	static char map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		String str;
		for(int t = 1; t <= T; t++) {
			map = new char[22][22];
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			for(int i = 1; i<=h;i++) {
				str = br.readLine();
				for(int j = 1; j <= w; j++) {
					map[i][j] = str.charAt(j-1);
					if(str.charAt(j-1) == '^' || str.charAt(j-1) == 'v' || str.charAt(j-1) == '<' || str.charAt(j-1) == '>') {
						tx = i;
						ty = j;
						switch(str.charAt(j-1)) {
						case '^':
							dir = 0;
							break;
						case 'v':
							dir = 1;
							break;
						case '<':
							dir = 2;
							break;
						case '>':
							dir = 3;
							break;
						}
					}
				}
			}
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			str = br.readLine();
			
			for(int i = 0;i<n;i++) {
				switch(str.charAt(i)) {
				case 'U':
					Up();
					break;
				case 'D':
					Down();
					break;
				case 'L':
					Left();
					break;
				case 'R':
					Right();
					break;
				case 'S':
					Shoot();
					break;
				}
			}
			
			
			System.out.print("#" + t + " ");
			for(int i = 1; i<=h;i++) {
				for(int j = 1; j <= w; j++){
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
	}

	static void Up() {
		dir = 0;
		Move('^');
	}
	
	static void Down() {
		dir = 1;
		Move('v');
	}
	
	static void Left() {
		dir = 2;
		Move('<');
	}
	
	static void Right() {
		dir = 3;
		Move('>');
	}
	
	static void Move(char c) {
		if(map[tx+dx[dir]][ty+dy[dir]] == '.') {
			map[tx][ty] = '.';
			tx += dx[dir];
			ty += dy[dir];
		}
		map[tx][ty] = c;
	}
	
	static void Shoot() {
		int bx = tx + dx[dir];
		int by = ty + dy[dir];
		while(bx > 0 && bx < h+1 && by > 0 && by < w+1) {
			switch(map[bx][by]) {
				case '#':			// 강철
					return;
				case '*':
					map[bx][by] = '.';
					return;
				default:
					break;
			}
			bx += dx[dir];
			by += dy[dir];
		}
	}
}
