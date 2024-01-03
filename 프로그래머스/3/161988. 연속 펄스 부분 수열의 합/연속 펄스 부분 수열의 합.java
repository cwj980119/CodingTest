class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int size = sequence.length;
        int[] a = new int[size];
        int[] b = new int[size];
        int k = 1;
        for(int i = 0; i < size; i++){
            a[i] = k;
            k*=-1;
            b[i] = k;
        }
        long x = 0, y = 0;
        for(int i = 0; i < size; i++){
            x += sequence[i] * a[i];
            y += sequence[i] * b[i];
            if(x < 0) x = 0;
            if(y < 0) y = 0;
            if(x > answer) answer = x;
            if(y > answer) answer = y;
        }
        
        return answer;
    }
}