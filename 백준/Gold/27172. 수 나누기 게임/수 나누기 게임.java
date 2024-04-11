import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    static HashMap<Integer, Integer> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        hm = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int t = Integer.parseInt(st.nextToken());
            hm.put(t, 0);
            arr[i] = t;
        }

        for(int p : arr){
            calc(p);
        }

        for(int p : arr){
            System.out.print(hm.get(p) + " ");
        }

    }

    static void calc(int k){
        for(int i = 1; i*i <= k; i++){
            if(k%i!=0) continue;
            if(hm.get(i) != null) {
                hm.replace(i, hm.get(i)+1);
                hm.replace(k, hm.get(k)-1);
            }
            if(i*i != k && hm.get(k/i) != null) {
                hm.replace(k/i, hm.get(k/i)+1);
                hm.replace(k, hm.get(k)-1);
            }
        }
    }
}