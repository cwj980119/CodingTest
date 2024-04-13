import java.util.*;


class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        Arrays.sort(plans,(a, b)->getNum(a[1])-getNum(b[1]));
        Stack<Subject> s = new Stack<>();
        LinkedList<String> ll = new LinkedList<>();
    
        String curr = plans[0][1];
        s.add(new Subject(plans[0][0], Integer.parseInt(plans[0][2])));
        
        for(int i = 1; i < plans.length; i++){
            int k = minus(plans[i][1], curr);
            curr = plans[i][1];
            while(k>0&&!s.isEmpty()){
                Subject c = s.pop();
                if(c.left > k) {
                    s.add(new Subject(c.name, c.left-k));
                    k = 0;
                }
                else{
                    ll.add(c.name);
                    k-=c.left;
                }
            }
            s.add(new Subject(plans[i][0], Integer.parseInt(plans[i][2])));
        }
        
        while(!s.isEmpty()){
            ll.add(s.pop().name);
        }
        
        answer = ll.toArray(new String[ll.size()]);
        
        return answer;
    }
    
    static int getNum(String num){
        int ans = (num.charAt(0)-'0') * 1000 + (num.charAt(1)-'0') * 100 + (num.charAt(3)-'0') * 10 + (num.charAt(4)-'0'); 
        return ans;
    }
    
    static int minus(String a, String b){
        int x = (a.charAt(0)-'0') * 10 + (a.charAt(1)-'0') - (b.charAt(0)-'0') * 10 - (b.charAt(1)-'0'); 
        int y = (a.charAt(3)-'0') * 10 + (a.charAt(4)-'0') - (b.charAt(3)-'0') * 10 - (b.charAt(4)-'0');
        return x*60 + y;
    }
    
    static class Subject{
        String name;
        int left;
        Subject(String name, int left){
            this.name = name;
            this.left = left;
        }
    }
}