import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
            int length = enroll.length;
            int[] answer = new int[length];
            HashMap<String, Integer> hashMap = new HashMap<>();
            People[] people = new People[length];
            for(int i = 0; i < length; i++){
                hashMap.put(enroll[i], i);
                people[i] = new People(enroll[i], referral[i]);
            }

            for(int i = 0; i < seller.length; i++){
                String s = seller[i];
                People curr = people[hashMap.get(s)];
                int money = amount[i] * 100;
                while(true){
                    curr.money += (money - (money/10));
                    money /= 10;
                    if(curr.parent.equals("-")) break;
                    if(money == 0) break;
                    curr = people[hashMap.get(curr.parent)];
                }
            }

            for(int i = 0; i < length; i++){
                answer[i] = people[i].money;
            }

            return answer;
        }

        static class People{
            String name;
            int money = 0;
            String parent;
            People(String name, String parent){
                this.name = name;
                this.parent = parent;
            }

        }
}