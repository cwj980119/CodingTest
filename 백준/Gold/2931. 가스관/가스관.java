import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

	public class Main {

		
		static char[][] field;
		static int r, c;
		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			String str;
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			field = new char[r+2][c+2];
			// 배열에 	주어진 지도를 저장
			for(int i = 1; i <= r; i++) {
				str = br.readLine();
				for(int j = 1; j <= c; j++) {
					field[i][j] = str.charAt(j-1);
				}
			}
			Coord answer = findEmpty(); // 빈 공간을 찾는 함수 호출
			System.out.println(answer.x + " " + answer.y + " " + findBlock(answer)); // 결과 출력
		}
		
		/**
		 * 주어진 지도에서 상하좌우에 길이 존재하지만 값이 비어있는 위치를 찾아 반환
		 * @return Coord
		 */
		static Coord findEmpty() {
			for(int i = 1; i <= r; i++) {
				for(int j = 1; j <= c; j++) {
					if(field[i][j] == '.') {
						// 현재 위치 위에 다음 4가지 길이 있을경우 비어있는 길이다.
						if(field[i-1][j] == '|' || field[i-1][j] == '+' || field[i-1][j] == '1' || field[i-1][j] == '4') {
							return new Coord(i,j);
						}
						// 현재 위치 아래에 다음 4가지 길이 있을경우 비어있는 길이다.
						if(field[i+1][j] == '|' || field[i+1][j] == '+' || field[i+1][j] == '2' || field[i+1][j] == '3') {
							return new Coord(i,j);
						}
						// 현재 위치 왼쪽에 다음 4가지 길이 있을경우 비어있는 길이다.
						if(field[i][j-1] == '-' || field[i][j-1] == '+' || field[i][j-1] == '1' || field[i][j-1] == '2') {
							return new Coord(i,j);
						}
						// 현재 위치 오른쪽에 다음 4가지 길이 있을경우 비어있는 길이다.
						if(field[i][j+1] == '-' || field[i][j+1] == '+' || field[i][j+1] == '3' || field[i][j+1] == '4') {
							return new Coord(i,j);
						}
					}
				}
			}
			return new Coord(-1,-1); // 케이스오류
		}
		
		/**
		 * 비어있는 위치를 받은후 올바른 값을 찾는 함수
		 * @param answer
		 * @return char
		 */
		static char findBlock(Coord answer) {
			int block = 0;
			int[] dir = {0b1000, 0b100, 0b10, 0b1}; // 4가지 방향 상하좌우를 비트연산을 이용하여 찾음
			// 현재 위치 위에 다음 4가지 길이 있을경우 해당 블록은 위로 뚫려있어야한다.
			if(field[answer.x-1][answer.y] == '|' || field[answer.x-1][answer.y] == '+' || field[answer.x-1][answer.y] == '1' || field[answer.x-1][answer.y] == '4') {
				block|=dir[0];
			}
			// 현재 위치 아래에 다음 4가지 길이 있을경우 해당 블록은 아래로 뚫려있어야한다.
			if(field[answer.x+1][answer.y] == '|' || field[answer.x+1][answer.y] == '+' || field[answer.x+1][answer.y] == '2' || field[answer.x+1][answer.y] == '3') {
				block|=dir[1];
			}
			// 현재 위치 왼쪽에 다음 4가지 길이 있을경우 해당 블록은 왼쪽으로 뚫려있어야한다.
			if(field[answer.x][answer.y-1] == '-' || field[answer.x][answer.y-1] == '+' || field[answer.x][answer.y-1] == '1' || field[answer.x][answer.y-1] == '2') {
				block|=dir[2];
			}
			// 현재 위치 오른쪽에 다음 4가지 길이 있을경우 해당 블록은 오른쪽으로 뚫려있어야한다.
			if(field[answer.x][answer.y+1] == '-' || field[answer.x][answer.y+1] == '+' || field[answer.x][answer.y+1] == '3' || field[answer.x][answer.y+1] == '4') {
				block|=dir[3];
			}
			
			// 비트 연산을 통해 찾은 블록을 char형으로 변환
			switch(block) {
			case 0b1111:
				return '+';
			case 0b1100:
				return '|';
			case 0b0011:
				return '-';
			case 0b0101:
				return '1';
			case 0b1001:
				return '2';
			case 0b1010:
				return '3';
			case 0b0110:
				return '4';
			}
			
			return '0';
		}
		
		//위치를 편의상 표현하기 위한 클래스
		static class Coord{
			int x;
			int y;
			public Coord(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}

	}