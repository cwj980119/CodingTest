import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static Point p[];
	static boolean map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int t = 0; t < T;t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			p = new Point[n+2];
			map = new boolean[n+2][n+2];
			for(int i = 0; i <= n+1;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[i][i] = true;
				p[i] = new Point(x,y);
			}
			for(int k=0; k <= n+1; k++) {
				for(int i=0; i <= n+1; i++) {
					for(int j=0; j <= n+1; j++) {
						map[i][j] = map[i][j]||(((getDist(i,k)<=1000)||map[i][k])&&((getDist(k,j)<=1000)||map[k][j]));
					}
				}
			}
			if(map[0][n+1]) System.out.println("happy");
			else System.out.println("sad");

		}
	}
	
	static float getDist(int i, int j) {
		float result = Math.abs(p[i].x-p[j].x)+Math.abs(p[i].y-p[j].y);
		return result;
	}

}