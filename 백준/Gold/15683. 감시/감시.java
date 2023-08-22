import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int space = 0;
    static int[][] map;
    static int sum = 0;
    static int min_size = 0;
    static ArrayList<Point> cctv = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        int cur;
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
            	cur = Integer.parseInt(st.nextToken());
                if (cur == 0) {
                    space++;
                } else if (cur == 6) {
                    // 벽
                } else {
                    cctv.add(new Point(j, i));
                }
                map[j][i] = cur;
            }
        }
        cctvType(0);
        System.out.println(space - min_size);
    }

    static int up(Point curr, List<Point> area) {
        int cnt = 0;
        for (int i = curr.y - 1; i >= 0; i--) {
            if (map[curr.x][i] == 0) {
                map[curr.x][i] = -1;
                cnt++;
                area.add(new Point(curr.x, i));
            }
            if (map[curr.x][i] == 6) break;
        }
        sum += cnt;
        return cnt;
    }

    static int down(Point curr, List<Point> area) {
        int cnt = 0;
        for (int i = curr.y + 1; i < n; i++) {
            if (map[curr.x][i] == 0) {
                map[curr.x][i] = -1;
                cnt++;
                area.add(new Point(curr.x, i));
            }
            if (map[curr.x][i] == 6) break;
        }
        sum += cnt;
        return cnt;
    }

    static int left(Point curr, List<Point> area) {
        int cnt = 0;
        for (int i = curr.x - 1; i >= 0; i--) {
            if (map[i][curr.y] == 0) {
                map[i][curr.y] = -1;
                cnt++;
                area.add(new Point(i, curr.y));
            }
            if (map[i][curr.y] == 6) break;
        }
        sum += cnt;
        return cnt;
    }

    static int right(Point curr, List<Point> area) {
        int cnt = 0;
        for (int i = curr.x + 1; i < m; i++) {
            if (map[i][curr.y] == 0) {
                map[i][curr.y] = -1;
                cnt++;
                area.add(new Point(i, curr.y));
            }
            if (map[i][curr.y] == 6) break;
        }
        sum += cnt;
        return cnt;
    }

    static void cctv1(int d) {
        if (d == cctv.size()) {
            if (sum > min_size) min_size = sum;
            return;
        }
        Point curr = cctv.get(d);
        List<Point> area = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            if (i == 0) cnt = right(curr, area);
            else if (i == 1) cnt = left(curr, area);
            else if (i == 2) cnt = down(curr, area);
            else if (i == 3) cnt = up(curr, area);

            cctvType(d + 1);
            for (Point p : area) {
				map[p.x][p.y] = 0;
			}
            sum -= cnt;
        }
    }

    static void cctv2(int d) {
        if (d == cctv.size()) {
            if (sum > min_size) min_size = sum;
            return;
        }
        Point curr = cctv.get(d);
        List<Point> area = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int cnt = 0;
            if (i == 0) {
                cnt = right(curr, area);
                cnt += left(curr, area);
            } else if (i == 1) {
                cnt = up(curr, area);
                cnt += down(curr, area);
            }
            cctvType(d + 1);
            for (Point p : area) {
				map[p.x][p.y] = 0;
			}
            sum -= cnt;
        }
    }

    static void cctv3(int d) {
        if (d == cctv.size()) {
            if (sum > min_size) min_size = sum;
            return;
        }
        Point curr = cctv.get(d);
        List<Point> area = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            if (i == 0) {
                cnt = down(curr, area);
                cnt += left(curr, area);
            } else if (i == 1) {
                cnt = up(curr, area);
                cnt += left(curr, area);
            } else if (i == 2) {
                cnt = up(curr, area);
                cnt += right(curr, area);
            } else if (i == 3) {
                cnt = right(curr, area);
                cnt += down(curr, area);
            }
            cctvType(d + 1);
            for (Point p : area) {
				map[p.x][p.y] = 0;
			}
            sum -= cnt;
        }
    }

    static void cctv4(int d) {
        if (d == cctv.size()) {
            if (sum > min_size) min_size = sum;
            return;
        }
        Point curr = cctv.get(d);
        List<Point> area = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            if (i == 0) {
                cnt = down(curr, area);
                cnt += left(curr, area);
                cnt += right(curr, area);
            } else if (i == 1) {
                cnt = up(curr, area);
                cnt += left(curr, area);
                cnt += right(curr, area);
            } else if (i == 2) {
                cnt = up(curr, area);
                cnt += right(curr, area);
                cnt += down(curr, area);
            } else if (i == 3) {
                cnt = left(curr, area);
                cnt += down(curr, area);
                cnt += up(curr, area);
            }
            cctvType(d + 1);
            for (Point p : area) {
				map[p.x][p.y] = 0;
			}
            sum -= cnt;
        }
    }

    static void cctv5(int d) {
        if (d == cctv.size()) {
            if (sum > min_size) min_size = sum;
            return;
        }
        Point curr = cctv.get(d);
        List<Point> area = new ArrayList<>();
        int cnt = 0;
        cnt = up(curr, area);
        cnt += down(curr, area);
        cnt += left(curr, area);
        cnt += right(curr, area);
        cctvType(d + 1);
        for (Point p : area) {
			map[p.x][p.y] = 0;
		}
        sum -= cnt;
    }

    static void cctvType(int deg) {
        if (deg == cctv.size()) {
            if (sum > min_size) min_size = sum;
            return;
        }
        Point p = cctv.get(deg);
        int i = map[p.x][p.y];
        switch (i) {
            case 1:
                cctv1(deg);
                break;
            case 2:
                cctv2(deg);
                break;
            case 3:
                cctv3(deg);
                break;
            case 4:
                cctv4(deg);
                break;
            case 5:
                cctv5(deg);
                break;
            default:
                break;
        }
    }


}