import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1931 {

	static class meeting implements Comparable<meeting> {
		int start;
		int end;
		
		meeting(int s, int e){
			this.start = s;
			this.end = e;
		}

		@Override
		public int compareTo(meeting o) {
			if(this.end == o.end) {
				return this.start > o.start?1:-1;
			}
			else return this.end > o.end?1:-1;
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<meeting> pq = new PriorityQueue<>();
		int s, e;
		for(int i = 0; i<n;i++) {
			st = new StringTokenizer(in.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			pq.add(new meeting(s,e));
		}
		int now = 0;
		int cnt = 0;
		for(int i = 0; i<n;i++) {
			meeting m = pq.poll();
			if(m.start >= now) {
				cnt++;
				now = m.end;
			}
		}
		
		System.out.println(cnt);
		

	}

}
