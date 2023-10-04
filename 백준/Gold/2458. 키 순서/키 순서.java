import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j<n;j++) {
				map[i][j] = false;
			}
			map[i][i] = true;
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1] = true;
		}
		
		for(int k=0; k < n; k++) {
			for(int i=0; i < n; i++) {
				for(int j=0; j < n; j++) {
					map[i][j] = map[i][j]||(map[i][k])&&(map[k][j]);
				}
			}
		}
		
		for(int i =0; i < n;i++) {
			for(int j = 0; j < n;j++) {
				if(!map[i][j]&&!map[j][i]) {
					break;
				}
				if(j == n-1) cnt++;
			}
		}
		System.out.println(cnt);

	}

}