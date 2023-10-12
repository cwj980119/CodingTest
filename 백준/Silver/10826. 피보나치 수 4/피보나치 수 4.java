import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		BigInteger a = new BigInteger("0"), b = new BigInteger("1"), temp;
		
		for(int i = 2; i <= n; i++) {
			temp = b;
			b = b.add(a);
			a = temp;
		}
		if(n == 0) System.out.println(0);
		else System.out.println(b);
	}

}