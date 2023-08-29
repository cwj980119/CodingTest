import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] dp = new int[x+1];
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		int curr, answer = 0;
		while(!q.isEmpty()) {
			curr = q.poll();
			if(curr == 1) {
				answer = 0;
				break;
			}
			if(curr%3==0) {
				if(curr/3 == 1) {
					answer = dp[curr] + 1;
					break;
				}
				if(dp[curr/3] == 0) {
					q.add(curr/3);
					dp[curr/3] = dp[curr] + 1;
				}
			}
			if(curr%2==0) {
				if(curr/2 == 1) {
					answer = dp[curr] + 1;
					break;
				}
				if(dp[curr/2] == 0) {
					q.add(curr/2);
					dp[curr/2] = dp[curr] + 1;
				}
			}
			if(curr == 2) {
				answer = dp[curr] + 1;
				break;
			}
			if(dp[curr-1] == 0) {
				q.add(curr-1);
				dp[curr-1] = dp[curr] + 1;
			}
			
		}
		System.out.println(answer);
	}

}