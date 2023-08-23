import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<Integer>[] adjlist = new ArrayList[101];
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int tc, start = 0, from, to;
				
		for(int t = 1; t <= 10; t++) {
			visited = new boolean[101];
			for(int i = 1; i <= 100; i++) {
				adjlist[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			tc = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < tc/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				adjlist[from].add(to);
			}
			bw.write("#" + t + " " + bfs(start) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static int bfs(int curr) {
		Queue<Point> q = new LinkedList<Point>();
		visited[curr] = true;
		q.add(new Point(0, curr));
		Point p;
		int d = 0, val = 0;
		while(!q.isEmpty()) {
			p = q.poll();
			if(p.x > d) {
				d = p.x;
				val = p.y;
			}
			else if(p.x == d && p.y > val) {
				val = p.y;
			}
			for (Integer next : adjlist[p.y]) {
				if(!visited[next]) {
					visited[next] = true;
					q.add(new Point(p.x + 1, next));
				}
			}
		}
		return val;
	}

}