import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        if(a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }

        StringBuilder zero = new StringBuilder();
        for(int i = 0; i < b.length(); i++){
            zero.append("0");
        }
        String aa = zero+a;
        String ab = a+zero;

        int[] aan = new int[aa.length()];
        int[] abn = new int[ab.length()];
        int[] bn = new int[b.length()];

        for(int i = 0; i < aa.length(); i++){
            aan[i] = aa.charAt(i) - '0';
            abn[i] = ab.charAt(i) - '0';
        }

        for(int j = 0; j < b.length(); j++){
            bn[j] = b.charAt(j) - '0';
        }

        int answer = aa.length();

label:  for(int i = 0; i <= a.length(); i++){
            for(int j = 0; j < b.length(); j++){
                if(aan[i+j] + bn[j] > 3) continue label;
            }
            answer = Math.min(answer, a.length() + b.length() - i);
            if(answer <= a.length()){
                answer = a.length();
                break;
            }
        }

        if(answer != a.length()){
    label:  for(int i = 0; i <= a.length(); i++){
                for(int j = 0; j < b.length(); j++){
                    if(abn[i+j] + bn[j] > 3) continue label;
                }

                answer = Math.min(answer, Math.max(a.length(), b.length()+i));
                if(answer <= a.length()){
                    answer = a.length();
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}