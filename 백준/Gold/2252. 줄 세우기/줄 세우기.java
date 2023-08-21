import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] all;
	static int[] cnt;
	static boolean[] visited;
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		all = new ArrayList[n+1];
		cnt = new int[n+1];
		visited = new boolean[n+1];
		q = new LinkedList<>();
		for(int i = 1; i<=n;i++) {
			all[i] = new ArrayList<>();
		}
		int a, b;
		for(int i = 0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			cnt[b]++;
			all[a].add(b);
		}
		for(int i = 1; i<=n;i++) {
			if(cnt[i] == 0) q.add(i);
		}
		
		int curr;
		while(!q.isEmpty()) {
			curr = q.poll();
			visited[curr] = true;
			bw.write(curr + " ");
			for (Integer next : all[curr]) {
				if(--cnt[next] == 0 && !visited[next]) {
					q.add(next);
				}
			}
		}
		for(int i = 1; i<=n;i++) {
			if(!visited[i]) bw.write(i + " ");
		}
		bw.flush();
		br.close();
		bw.close();
		
	}

}