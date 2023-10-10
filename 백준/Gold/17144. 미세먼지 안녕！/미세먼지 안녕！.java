import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int r, c, t;
	static int room[][] = new int[51][51];
	static List<Integer> airCleaner = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		
		
		int dust;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				dust = Integer.parseInt(st.nextToken());
				if (dust == -1) airCleaner.add(i);
				room[i][j] = dust;
			}
		}
		for (int i = 0; i < t; i++) {
			Spread();
			AirFlow();
		}
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (room[i][j] != -1) sum += room[i][j];
			}
		}
		System.out.println(sum);
	}
	static void Spread() {
		int spread_room[][] = new int[51][51];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int curr_room = room[i][j];
				int particle = curr_room / 5;
				if (i > 0 && room[i - 1][j] != -1) {
					spread_room[i - 1][j] += particle;
					curr_room -= particle;
				}
				if (j > 0 && room[i][j - 1] != -1) {
					spread_room[i][j - 1] += particle;
					curr_room -= particle;
				}
				if (i < r - 1 && room[i + 1][j] != -1) {
					spread_room[i + 1][j] += particle;
					curr_room -= particle;
				}
				if (j < c - 1 && room[i][j + 1] != -1) {
					spread_room[i][j + 1] += particle;
					curr_room -= particle;
				}
				spread_room[i][j] += curr_room;
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				room[i][j] = spread_room[i][j];
			}
		}
	}
	
	static void AirFlow() {
		int cleaner;
		cleaner = airCleaner.get(0);
		for (int i = cleaner - 1; i > 0; i--) {
			room[i][0] = room[i - 1][0];
		}
		for (int j = 0; j < c - 1; j++) {
			room[0][j] = room[0][j + 1];
		}
		for (int i = 0; i < cleaner; i++) {
			room[i][c - 1] = room[i + 1][c - 1];
		}
		for (int j = c - 1; j > 1; j--) {
			room[cleaner][j] = room[cleaner][j - 1];
		}
		room[cleaner][1] = 0;

		cleaner = airCleaner.get(1);
		for (int i = cleaner + 1; i < r - 1; i++) {
			room[i][0] = room[i + 1][0];
		}
		for (int j = 0; j < c - 1; j++) {
			room[r-1][j] = room[r-1][j + 1];
		}
		for (int i = r - 1; i > cleaner; i--) {
			room[i][c - 1] = room[i - 1][c - 1];
		}
		for (int j = c - 1; j > 1; j--) {
			room[cleaner][j] = room[cleaner][j - 1];
		}
		room[cleaner][1] = 0;
	}
}