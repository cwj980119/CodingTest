class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int o_count = 0;
        int x_count = 0;
        char winner =' ';
        int[] line = new int[]{0,0};
        
        for(int i = 0; i < 3; i++){
            char curr = ' ';
            for(int j = 0; j < 3; j++){
                if(j == 0) curr = board[i].charAt(j);
                else if (j == 2 && curr != '.' && curr == board[i].charAt(1) && curr == board[i].charAt(2)){
                    if(line[0] == 1) answer = 0;
                    winner = curr;
                    line[0] = 1;
                }
                if(board[i].charAt(j) == 'O') o_count++;
                else if(board[i].charAt(j) == 'X') x_count++;
            }
        }
        System.out.println(o_count);
        System.out.println(x_count);
        for(int i = 0; i < 3; i++){
            char curr = ' ';
            for(int j = 0; j < 3; j++){
                if(j == 0) curr = board[j].charAt(i);
                else if (j == 2 && curr != '.' && curr == board[1].charAt(i) && curr == board[2].charAt(i)){
                    if(line[0] == 2) answer = 0;
                    winner = curr;
                    line[0] = 2;
                }
            }
        }
        
        if(winner == ' '){
            if(board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) winner = board[0].charAt(0);
            if(board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) winner = board[0].charAt(2);
        }
        
        if(o_count == x_count){
         if(winner == 'O') answer = 0;
        }
        else if(o_count == x_count + 1){
            if(winner == 'X') answer = 0;
        }
        else answer = 0;
        return answer;
    }
}