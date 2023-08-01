import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 1; test_case++) {
			List<Integer> list = new ArrayList<>();
			String s = br.readLine();
			StringTokenizer st = new StringTokenizer(s);
			int n = Integer.parseInt(st.nextToken());
			s = br.readLine();
			st = new StringTokenizer(s);
			for(int i = 0 ; i<100;i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			list.sort(null);
			int f = 0, l = 0;
			for(int i = 0; i<n;i++) {
				list.sort(null);
				f = list.get(0);
				l = list.get(99);
				if(f == l || l - f == 1) break;
				list.set(0, f+1);
				list.set(99,l-1);
			}
			list.sort(null);
			f = list.get(0);
			l = list.get(99);
			System.out.println("#"+ test_case+ " " + (l - f));
		}
	}
	
}
