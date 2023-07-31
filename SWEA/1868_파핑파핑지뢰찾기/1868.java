import java.util.Scanner;
 
class Solution
{
     
    static char[][] mine_map;
    static int[][] num_map;
     
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
     
    static int n;
     
    static int cnt_mine(int r, int c) {
        int cnt = 0, dr = 0, dc = 0;
        for (int i = 0; i<8; i++) {
            dr = r + dx[i];
            dc = c + dy[i];
            if (dr < 0 || dr >= n || dc < 0 || dc >= n) continue;
             
            if (mine_map[dr][dc] == '*') cnt+=1;
        }
        return cnt;
    }
     
    static void open(int r, int c) {
        int cnt = 0, dr = 0, dc = 0;
        num_map[r][c] = -1;
        for (int i = 0; i < 8; i++) {
            dr = r + dx[i];
            dc = c + dy[i];
            if (dr < 0 || dr >= n || dc < 0 || dc >= n) continue;
            if (num_map[dr][dc] == 0) open(dr, dc);
            num_map[dr][dc] = -1;
        }
    }
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            String s;
            mine_map = new char[n][n];
            num_map = new int[n][n];
            for(int i = 0; i < n; i++) {
                mine_map[i] =  sc.next().toCharArray();
                 
            }
            for(int i = 0; i<n;i++) {
                for(int j = 0 ;j<n;j++) {
                    if(mine_map[i][j] == '*') num_map[i][j] = -1;
                    else num_map[i][j] = cnt_mine(i, j);
                }
            }
            int cnt = 0;
            for(int i = 0; i<n;i++) {
                for(int j = 0 ;j<n;j++) {
                    if(num_map[i][j] == 0) {
                        cnt++;
                        open(i,j);
                    }
                }
            }
            for(int i = 0; i<n;i++) {
                for(int j = 0 ;j<n;j++) {
                    if(num_map[i][j] != -1) {
                        cnt++;
                    }
                }
            }       
            System.out.println("#" + test_case + " " + cnt);
        }
         
    }
     
}
