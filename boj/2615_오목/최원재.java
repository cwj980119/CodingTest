import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		//////////////////////////////////////////////////////////////
		// 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
		//////////////////////////////////////////////////////////////
//		System.setIn(new FileInputStream("Test4.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] field = new String[19][19];
		for(int i = 0; i<19;i++) {
			field[i] = br.readLine().split(" ");
		}
		
		String win = "0";
		int x = 0, y = 0;
		
		String cur;
label:	for(int i = 0; i <19;i++) {
			for(int j = 0; j<19;j++) {
				if(field[i][j].equals("1") || field[i][j].equals("2")) {
					cur = field[i][j];
					
					//대각선 위
					if(i>=4 && j <15) {
						for(int k = 1; k<6;k++) {
							if(k==5) {
								if(i-k < 0 || j+k >= 19) {
									win = cur;
									x = i+1;
									y = j+1;
									break label;
								}else if(!field[i-k][j+k].equals(cur)) {
									win = cur;
									x = i+1;
									y = j+1;
									break label;
								}
								else break;
							}
							if(i+1 < 19 && j-1 >= 0 && field[i+1][j-1].equals(cur)) break;
							if(!field[i-k][j+k].equals(cur)) break;
						}
					}
					// 오른쪽
					if(j <15) {
						for(int k = 1; k<6;k++) {
							if(k==5) {
								if(j+k >= 19) {
									win = cur;
									x = i+1;
									y = j+1;
									break label;
								}else if(!field[i][j+k].equals(cur)) {
									win = cur;
									x = i+1;
									y = j+1;
									break label;
								}
								else break;
							}
							if(j-1 >= 0 && field[i][j-1].equals(cur)) break;
							if(!field[i][j+k].equals(cur)) break;
						}
					}
					//대각선 아래
					if(i < 15 && j <15) {
						for(int k = 1; k<6;k++) {
							if(k==5) {
								if(i+k >= 19 || j+k >= 19) {
									win = cur;
									x = i+1;
									y = j+1;
									break label;
								}else if(!field[i+k][j+k].equals(cur)) {
									win = cur;
									x = i+1;
									y = j+1;
									break label;
								}
								else break;
							}
							if(i-1 >= 0 && j-1 >= 0 && field[i-1][j-1].equals(cur)) break;
							if(!field[i+k][j+k].equals(cur)) break;
						}
					}
					
					//아래
					if(i < 15) {
						for(int k = 1; k<6;k++) {
							if(k==5) {
								if(i+k >= 19) {
									win = cur;
									x = i+1;
									y = j+1;
									break label;
								}else if(!field[i+k][j].equals(cur)) {
									win = cur;
									x = i+1;
									y = j+1;
									break label;
								}
								else break;
							}
							if(i-1 >= 0 && field[i-1][j].equals(cur)) break;
							if(!field[i+k][j].equals(cur)) break;
						}
					}
					
					
				}
			}
		}
		System.out.println(win);
		if(!win.equals("0")) {
			System.out.println(x + " " + y);			
		}
	}
}

