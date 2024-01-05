import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();
        int n = friends.length;
        int[][] table = new int[n][n];
        int[][] point = new int[n][2];
        int[] this_month = new int[n];

        for(int i = 0; i < n; i++){
            hashMap.put(friends[i], i);
        }
        for(String s : gifts){
            String[] a = s.split(" ");
            int from = hashMap.get(a[0]);
            int to = hashMap.get(a[1]);
            table[from][to]++;
            point[from][0]++;
            point[to][1]++;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(table[i][j] > table[j][i]) this_month[i]++;
                if(table[i][j] == table[j][i] && (point[i][0]-point[i][1]) > (point[j][0]-point[j][1])) this_month[i]++;
            }
            answer=Math.max(answer, this_month[i]);
        }


        return answer;
    }
}