import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int n, k, l;
	static HashMap<String, Boolean> map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			map = new HashMap<>();
			String s = br.readLine();
			l = n/4;
			for(int j = 0; j < l; j++) {
				for(int i = 0; i < 4; i++) {
					map.put(s.substring(i*l, (i+1)*l), true);
				}
				s = s.concat(String.valueOf(s.charAt(0)));
				s = s.substring(1);				
			}
			List<String> keySet = new ArrayList<>(map.keySet());
			Collections.sort(keySet);
			String answer = keySet.get(keySet.size()-k);
			int decimal = 0;
			for(int i = 0; i < l; i++) {
				decimal *= 16;
				if(answer.charAt(i)>='A') decimal += ((int)(answer.charAt(i)-'A')+10);
				else decimal+=(int)(answer.charAt(i)-'0');
			}
			sb.append("#"+t+" "+decimal+"\n");
		}
		System.out.println(sb);
	}

}