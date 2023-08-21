import java.util.Scanner;

public class Main {

	static int n, m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		int[] arr = new int[n+1];
		
		arr[0] = 0;
		for(int i = 1; i <= n;i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		int sum = 0;
		int s, e;
		for(int i = 0; i<m; i++) {
			s = sc.nextInt();
			e = sc.nextInt();
			sum = arr[e] - arr[s-1];
			System.out.println(sum);
		}
		
		
	}

}