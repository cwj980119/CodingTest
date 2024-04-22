class Solution {
    public int[] solution(String s) {
        int s_len = s.length();
        int[] alphabet = new int[26];
        int[] answer = new int[s_len];
        
        for(int i = 0; i < s_len; i++){
            answer[i] = -1;
        }
        
        for(int i = 0; i < 26; i++){
            alphabet[i] = -1;
        }
        
        for(int i = 0; i < s_len; i++){
            char c = s.charAt(i);
            if(alphabet[c-'a'] == -1) {
                alphabet[c-'a'] = i;
                continue;
            }
            answer[i] = i - alphabet[c-'a'];
            alphabet[c-'a'] = i;
        }
        
        return answer;
    }
}