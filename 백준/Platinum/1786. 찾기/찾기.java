import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		String P = br.readLine();
		int tl = T.length(), pl = P.length();
		int pi[] = new int[pl];
		int i = 0;
		for(int j = 1; j < pl; j++) {
			while(i>0 && P.charAt(i)!=P.charAt(j)) {
				i=pi[i-1];
			}
			
			if(P.charAt(i)==P.charAt(j)) {
				pi[j] = ++i;
			}
		}
		i = 0;
		List<Integer> answer = new ArrayList<Integer>();
		for(int j = 0; j < tl; j++) {
			while(i>0 && P.charAt(i) != T.charAt(j)) {
				i=pi[i-1];
			}
			if(P.charAt(i) == T.charAt(j)) {
				i++;
				if(i == pl) {
					answer.add(j-pl+2);
					i = pi[i-1];
				}
			}
		}
		System.out.println(answer.size());
		for (Integer integer : answer) {
			System.out.print(integer + " ");
		}
	}

}