import java.io.*;
import java.util.PriorityQueue;
 
class Solution
{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     
    static int n;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {-1, 1, 0, 0}; //상하좌우
    static int dy[] = {0, 0, -1, 1}; //상하좌우
     
    public static int find() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[0])-(b[0]));  //람다식?
        pq.add(new int[]{0,0,0});
        visited[0][0] = true;
        int cur[];
        int nr , nc;
        while(!pq.isEmpty()) {
            cur = pq.poll();
            if(cur[1] == n-1 && cur[2] == n-1 ) return cur[0];
            for( int i = 0; i<4;i++) {
                nr = cur[1] + dx[i];
                nc = cur[2] + dy[i];
                if(nr >= n || nr < 0 || nc >=n || nc < 0) continue;
                if(!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.add(new int[] {map[nr][nc]+cur[0], nr, nc});
                }
            }
        }
        return 0;
    }
     
    public static void main(String args[]) throws Exception
    {
        int T = Integer.parseInt(br.readLine().trim());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = Integer.parseInt(br.readLine().trim());
             
            map = new int[n][n];
            visited = new boolean[n][n];
             
            String[] line;
             
            for(int i = 0; i<n;i++) {
                line = br.readLine().split("");
                for(int j = 0; j<n;j++) {
                    map[i][j] = Integer.parseInt(line[j]);
                }
            }
             
            int result = find();
            bw.write("#"+test_case + " " + result + "\n" );
             
        }       
        bw.flush();
        br.close();
        bw.close();
    }
}
