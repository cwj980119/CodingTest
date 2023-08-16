import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][] check;
	static int r, c;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r+2][c+2];
		check = new boolean[r+2][c+2];
		String str;
		for(int i = 1; i <= r; i++) {
			str = br.readLine();
			for(int j = 1; j <=c ;j++) {
				map[i][j] = str.charAt(j-1);
			}
		}
		int cnt = 0;
		for(int i = 1; i <= r;i++) {
			if(find(i,1)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static boolean find(int cr, int cc) {
		int nr, nc;
		int[] dir = {-1, 0, 1};
		if(cc == c) return true;
		for(int i = 0; i < 3; i++) {
			nr = cr + dir[i];
			nc = cc + 1;
			if(map[nr][nc] == '.' && !check[nr][nc]) {
				map[nr][nc] = '-';
				if(find(nr, nc)) return true;
				map[nr][nc] = '.';
			}
			else check[nr][nc] = true;
		}
		check[cr][cc] = true;
		return false;
	}

}