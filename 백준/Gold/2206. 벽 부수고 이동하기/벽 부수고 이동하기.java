import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] field;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        field = new int[n+2][m+2];
        for(int i = 0; i < n+2; i++){
            field[i][0] = field[i][m+1] = -1;
        }
        for(int i = 0; i < m+2; i++){
            field[0][i] = field[n+1][i] = -1;
        }

        for(int i = 1; i < n+1; i++){
            String s = br.readLine();
            for(int j = 1; j < m+1; j++){
                field[i][j] = s.charAt(j-1)-'0';
            }
        }

        Queue<Area> q = new LinkedList<>();
        visited = new boolean[n+2][m+2][2];
        q.add(new Area(new Point(1,1),1,0));
        Area current = new Area(new Point(-1,-1),-1,-1);
        int nx, ny, nb;

        while (!q.isEmpty()){
            current = q.poll();
            if(visited[current.p.x][current.p.y][current.isBreak]) continue;
            visited[current.p.x][current.p.y][current.isBreak] = true;
            if(current.p.x == n && current.p.y == m) break;
            for(int i = 0; i < 4; i++){
                nx = current.p.x + dx[i];
                ny = current.p.y + dy[i];
                nb = current.isBreak;

                if(nx < 1 || nx > n || ny < 1 || ny > m) continue;

                if(field[nx][ny] == 0 && !visited[nx][ny][nb]){
                    q.add(new Area(new Point(nx,ny), current.distance+1, nb));
                }

                if(field[nx][ny] == 1 && !visited[nx][ny][1] && nb == 0){
                    q.add(new Area(new Point(nx,ny), current.distance+1, 1));
                }
            }
        }
        if(current.p.x == n && current.p.y == m) System.out.println(current.distance);
        else System.out.println(-1);

    }

    static class Area{
        Point p;
        int distance;
        int isBreak;

        Area(Point p, int distance, int isBreak){
            this.p = p;
            this.distance = distance;
            this.isBreak = isBreak;
        }
    }
}