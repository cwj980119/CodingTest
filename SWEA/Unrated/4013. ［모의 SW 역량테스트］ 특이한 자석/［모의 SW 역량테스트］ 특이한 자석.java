import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] magnet = new int[5][8];
	static int[] arrow = new int[5];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t=1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= 4 ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 1; i<=4; i++) {
				arrow[i] = 0;
			}
			int num, dir;
			int sum = 0;
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				num = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				rotate(num, dir, 0);
			}
			int x = 1;
			for(int q = 1; q <= 4; q++) {
				sum += magnet[q][arrow[q]]*x;
				x*=2;
			}
			sb.append("#"+t+" "+sum+"\n");
		}
		System.out.println(sb);
		
	}
	
	static void rotate(int num, int dir, int from) {
		if(num!=4 && from!=1 && magnet[num][(arrow[num]+2)%8] != magnet[num+1][(arrow[num+1]+6)%8]) rotate(num+1, -dir, -1);
		if(num!=1 && from!=-1 && magnet[num][(arrow[num]+6)%8] != magnet[num-1][(arrow[num-1]+2)%8]) rotate(num-1, -dir, 1);
		arrow[num] = (arrow[num]-dir+8)%8;
	}

}