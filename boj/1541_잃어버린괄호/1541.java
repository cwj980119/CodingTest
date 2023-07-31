import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Main
{
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
	public static void main(String args[]) throws Exception
	{

		String line = br.readLine();
		int len = line.length();
		ArrayList<String> arr = new ArrayList<>();
		
		int cur = 0;
		int cnt = 0;
		for(int i = 0; i < len;i++) {
			if(line.charAt(i) == '+' || line.charAt(i) == '-') {
				arr.add(line.substring(cur, i));
				cnt++;
				arr.add(line.substring(i, i+1));
				cnt++;
				cur = i+1;
			}
		}
		cnt++;
		arr.add(line.substring(cur));
		

		int sum = 0;
		int sub_sum = 0;
		int next = 0;
		for(String s : arr) {
			
			if(s.equals("-")) {
				break;
			}
			else if(s.equals("+")) {
				
			}
			else {
				sum+=Integer.parseInt(s);
			}
			next++;
		}
		for( int i = next;i<arr.size();i++) {
			if(arr.get(i).equals("-")) {
				sum -= sub_sum;
				sub_sum = 0;
			}
			else if(arr.get(i).equals("+")) {
				continue;
			}
			else {
				sub_sum+=Integer.parseInt(arr.get(i));
			}
		}
		sum -= sub_sum;
		bw.write(""+sum);
		
		bw.flush();
		br.close();
		bw.close();
	}
	
	
}
