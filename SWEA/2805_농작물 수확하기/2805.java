import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			String s;
			
			int arr[][] = new int[n][n];

			for(int i = 0; i<n;i++) {
				s = sc.next();
				for(int j = 0; j<n;j++) {
					arr[i][j] = Character.getNumericValue(s.charAt(j));
				}
			}
			int sum = 0;
			int h = n/2;
			for(int i = 0; i < h;i++) {
				for(int j = h-i; j <= h+i; j++) {
					sum += arr[i][j];
				}
			}
			for(int i = 0; i <n;i++) {
				sum += arr[h][i];
			}
			for(int i = 1;i <= h;i++) {
				for(int j = i; j < n - i;j++) {
					sum += arr[h+i][j];
				}
			}
			System.out.println("#" + test_case + " " + sum);

		}

	}

}
