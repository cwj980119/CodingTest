import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[][] field;
	static ArrayList<Point> core;
	static int n, minLine;
	static int []dx = {-1, 1, 0, 0};
	static int []dy = {0, 0, -1, 1};
	static int cnt, maxCnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			core = new ArrayList<>();
			field = new int[n][n];
			minLine = n*n;
			cnt = maxCnt = 0;
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					field[i][j] = Integer.parseInt(st.nextToken());
					if(field[i][j] == 1) core.add(new Point(i,j));
				}
			}
			
			connect(0);
			bw.write("#" + t + " " + minLine+"\n");
			
		}
		bw.flush();
		bw.close();
		br.close();

	}
	
	static void connect(int d) {
		if(d == core.size()) {
			if(cnt > maxCnt) {
				maxCnt = cnt;
				minLine = calcLine();
			}
			else if(cnt == maxCnt) {
				minLine = (int)Math.min(minLine, calcLine());				
			}
			return;
		}
		if(core.size() - d + cnt < maxCnt) return;
		for(int i = 0; i < 4; i++) {
			ArrayList<Point> line = new ArrayList<>();
			if(Line(i, core.get(d), line)) {
				drawLine(line);
				cnt++;
				connect(d+1);
				cnt--;
				eraseLine(line);
			}
		}
		connect(d+1);
	}
	
	static boolean Line(int dir, Point p, ArrayList<Point> line) {
		int nx = p.x + dx[dir];
		int ny = p.y + dy[dir];
		while(nx >= 0 && nx < n && ny >= 0 && ny < n) {
			if(field[nx][ny] == 1) return false;
			line.add(new Point(nx,ny));
			nx += dx[dir];
			ny += dy[dir];
		}
		return true;
	}
	
	static void drawLine(ArrayList<Point> line) {
		for (Point p : line) {
			field[p.x][p.y] = 1;
		}
	}
	
	static void eraseLine(ArrayList<Point> line) {
		for (Point p : line) {
			field[p.x][p.y] = 0;
		}
	}
	
	static int calcLine() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(field[i][j] == 1) cnt++;
			}
		}
		return cnt - core.size();
	}

}