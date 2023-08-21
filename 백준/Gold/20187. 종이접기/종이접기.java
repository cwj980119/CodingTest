import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, size_x, size_y;
	static int[][] paper;
	static int s_x,s_y,e_x,e_y;
	static Stack<Character> stack;
	
	public static void main(String[] args) throws Exception {
		int k, h;
		st = new StringTokenizer(br.readLine());
		k = Integer.parseInt(st.nextToken());
		
		n = getSize(k);
		paper = new int[n+2][n+2];
		
		s_x = s_y = 1;
		e_x = e_y = n;
		
		stack = new Stack<>();
		st = new StringTokenizer(br.readLine());
		char curr;
		for(int i = 0; i < k*2;i++) {
			curr = st.nextToken().charAt(0);
			stack.add(curr);
			switch(curr) {
			case 'D':
				s_x = (s_x+e_x)/2 +1;
				break;
			case 'U':
				e_x = (s_x+e_x)/2;
				break;
			case 'R':
				s_y = (s_y + e_y)/2 +1;
				break;
			case 'L':
				e_y = (s_y+e_y)/2;
				break;
			}
		}
		st = new StringTokenizer(br.readLine());
		paper[s_x][s_y] = Integer.parseInt(st.nextToken());
		size_x = size_y = 1;
		while(!stack.empty()) {
			curr = stack.pop();
			switch(curr) {
			case 'D':
				Down();
				break;
			case 'U':
				Up();
				break;
			case 'R':
				Right();
				break;
			case 'L':
				Left();
				break;
			}
		}
		
		for(int i = 1; i<=n;i++) {
			for(int j = 1; j <=n; j++) {
				System.out.print(paper[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static int getSize(int k) {
		int x = 1;
		for(int i = 0; i<k;i++) {
			x*=2;
		}
		return x;
	}
	
	static void Down() {
		int d = 1;
		for(int i = s_x; i <= e_x; i++) {
			for(int j = s_y; j <= e_y; j++) {
				switch(paper[i][j]) {
				case 0:
					paper[i-d][j] = 2;
					break;
				case 1:
					paper[i-d][j] = 3;
					break;
				case 2:
					paper[i-d][j] = 0;
					break;
				case 3:
					paper[i-d][j] = 1;
					break;
				}
			}
			d+=2;
		}
		s_x -= size_x;
		size_x *=2;
		
	}
	static void Up() {
		int d = 1;
		for(int i = e_x; i >= s_x; i--) {
			for(int j = e_y; j >= s_y; j--) {
				switch(paper[i][j]) {
				case 0:
					paper[i+d][j] = 2;
					break;
				case 1:
					paper[i+d][j] = 3;
					break;
				case 2:
					paper[i+d][j] = 0;
					break;
				case 3:
					paper[i+d][j] = 1;
					break;
				}
			}
			d+=2;
		}
		e_x += size_x;
		size_x *=2;
	}
	static void Right() {
		int d = 1;
		for(int i = s_x; i <= e_x; i++) {
			d = 1;
			for(int j = s_y; j <= e_y; j++) {
				switch(paper[i][j]) {
				case 0:
					paper[i][j-d] = 1;
					break;
				case 1:
					paper[i][j-d] = 0;
					break;
				case 2:
					paper[i][j-d] = 3;
					break;
				case 3:
					paper[i][j-d] = 2;
					break;
				}
				d+=2;
			}
		}
		s_y -= size_y;
		size_y *=2;
	}
	static void Left() {
		int d = 1;
		for(int i = e_x; i >= s_x; i--) {
			d = 1;
			for(int j = e_y; j >= s_y; j--) {
				switch(paper[i][j]) {
				case 0:
					paper[i][j+d] = 1;
					break;
				case 1:
					paper[i][j+d] = 0;
					break;
				case 2:
					paper[i][j+d] = 3;
					break;
				case 3:
					paper[i][j+d] = 2;
					break;
				}
				d+=2;
			}
		}
		e_y += size_y;
		size_y *=2;
	}
	
}