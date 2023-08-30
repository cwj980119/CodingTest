import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long pipe[][][];
	static long field[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		field = new long[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		pipe = new long[3][n][n];
		
		for(int i = 1; i < n; i++) {
			if(field[0][i] == 0) pipe[0][0][i] = 1;
			else break;
		}
		
		for(int i = 1; i <n;i++) {
			for(int j = 2; j < n;j++) {
				if(field[i][j] == 0) {				
					pipe[0][i][j] = pipe[0][i][j-1] + pipe[2][i][j-1];
					pipe[1][i][j] = pipe[1][i-1][j] + pipe[2][i-1][j];
					if(field[i-1][j] == 0 && field[i][j-1] == 0) pipe[2][i][j] = pipe[0][i-1][j-1] + pipe[1][i-1][j-1] + pipe[2][i-1][j-1];
				}
			}
		}
		long answer = pipe[0][n-1][n-1] + pipe[1][n-1][n-1] + pipe[2][n-1][n-1];
		System.out.println(answer);
	}

}