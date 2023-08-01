import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer> list = new ArrayList();
	static boolean[] visited;
	static int n, m;
	
	static void recurr(int d) {
		if(d == 1) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i<n+1;i++) {
			if(!visited[i]) {
				list.add(i);
				visited[i] = true;
				recurr(d-1);
				list.remove(list.size()-1);
				visited[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		visited = new boolean[n+1];
		for(int i = 1; i < n+1 ;i++) {
			list.add(i);
			visited[i] = true;
			recurr(m);
			list.remove(list.size()-1);
			visited[i] = false;
		}
		br.close();
	}

}
