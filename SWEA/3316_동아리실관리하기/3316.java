import java.util.Arrays;
import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String order = sc.next();
             
            int len = order.length();
            int dp [][] = new int[len + 1][16];
            dp[0][1] = 1;
            for(int i = 0; i<len;i++) {
                int next = 1 << order.charAt(i) - 'A';
                for (int j = 1; j < 16; j++) {
                    for(int k = 1; k < 16; k++) {
                        if(((j&k)>0) && ((k&next) > 0)) {
                            dp[i+1][k] += dp[i][j];
                            dp[i+1][k] %= 1000000007;
                        }
                    }
                }
            }
            int result = 0;
            for(int i = 1; i<16;i++) {
                result += dp[len][i];
                result %= 1000000007;
            }
            System.out.println("#" + test_case +' ' +result);
        }
    }
}
