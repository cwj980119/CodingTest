import java.util.Scanner;

public class Main {
	
	
	static boolean[] switches;
	static int s = 0;
	
	static void boys(int n) {
		int k = n;
		while(k <= s) {
			switches[k] = !switches[k];
			k += n;
		}
	}
	
	
	static void girls(int n) {
		switches[n] = !switches[n];
		int i = 1;
		while(true) {
			if(n-i >= 1 && n+i <= s && switches[n-i] == switches[n+i]) {
				switches[n-i] = !switches[n-i];
				switches[n+i] = !switches[n+i];
				i++;
			}
			else break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextInt();
		switches = new boolean[s+1];
		
		int t = 0;
		for(int i = 1; i<= s;i++) {
			t= sc.nextInt();
			switches[i] = (t == 0)? false : true;
		}
		int p = sc.nextInt();

		int people[] = new int[p];
		int numbers[] = new int[p];
		
		for(int i = 0; i< p;i++) {
			people[i] = sc.nextInt();
			numbers[i] = sc.nextInt();
		}
		
		for(int i= 0;i<p;i++) {
			if(people[i] == 1) boys(numbers[i]);
			else girls(numbers[i]);
		}
		
		for(int i =1;i<=s;i++) {
			if(switches[i]) System.out.print(1 + " ");
			else System.out.print(0 + " ");
			if(i%20 == 0) System.out.println();
		}
	}
	
}
