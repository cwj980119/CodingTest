import java.util.PriorityQueue;

class Solution {

        static int[][] table;

        public int solution(int k, int n, int[][] reqs) {
            int answer = 0;
            // 1. 각 유형별 멘토 숫자에 따른 소요시간을 확인한다.
            table = new int[k+2][n+2];
            for(int i = 1; i <= k; i++){
                for(int j = 1; j <= n-k+1;j++){
                    table[i][j] = mentoring(i,j, reqs);
                    if(table[i][j] == table[i][j-1]) break;
                }
            }

            // 2. 소요시간의 합이 최소가 되는 구성을 찾는다.
            int[] idx = new int[k+1]; // table index 배열
            for(int i = 0; i <= k; i++) idx[i] = 1;

            for(int i = 0; i < n-k; i++){
                int max = -1;
                int type = 0;
                for(int j = 1; j <= k; j++){
                    if(table[j][idx[j]] - table[j][idx[j]+1] > max){
                        max = table[j][idx[j]] - table[j][idx[j]+1];
                        type = j;
                    }
                }
                idx[type]++;
            }
            for(int i = 1; i<=k; i++) answer+=table[i][idx[i]];

            return answer;
        }

        public int mentoring(int type, int mento, int[][] reqs){
            int sum = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i = 0; i < mento; i++){
                pq.add(0);
            }
            for(int[] r: reqs){
                if(r[2] != type) continue;
                int curr = pq.poll();
                if(r[0] < curr) sum+=(curr-r[0]);
                else curr = r[0];
                pq.add(curr+r[1]);
            }
            return sum;
        }
    }