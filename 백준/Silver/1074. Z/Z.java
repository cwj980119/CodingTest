import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, r, c, size, cnt;
	static int [][]map;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		getSize();
		answer = cnt = 0;
		dNc(0,0,size, 0);
		System.out.println(answer);
		
	}
	
	
	static void dNc(int x, int y, int length, int cnt) {
		if(answer != 0) {
			return;
		}
		if(length == 1) {
			if(x == r && y == c) answer = cnt;
			return;
		}
		int ns = length/2;
		int pos = getPos(x, y, ns);
		switch(pos) {
		case 0:
			dNc(x,y,ns, cnt);
			break;
		case 1:
			dNc(x,y + ns,ns,cnt+ns*ns);
			break;
		case 2:
			dNc(x + ns,y,ns,cnt+ns*ns*2);
			break;
		case 3:
			dNc(x + ns,y + ns,ns,cnt+ns*ns*3);
			break;
		}
	}
	
	static void getSize() {
		size = 1;
		for(int i = 0; i < N;i++) {
			size*=2;
		}
	}
	
	static int getPos(int x, int y, int length) {
		int nx = x + length;
		int ny = y + length;
		if(r < nx && c < ny) return 0;
		if(r < nx && c >= ny) return 1;
		if(r >= nx && c < ny) return 2;
		if(r >= nx && c >= ny) return 3;
		return -1;
	}

}