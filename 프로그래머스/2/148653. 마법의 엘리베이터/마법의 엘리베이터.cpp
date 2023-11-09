#include <string>
#include <vector>

using namespace std;

int solution(int storey) {
    int answer = 0;
    int rest;
    while(storey > 0){
        rest = storey % 10;
        storey /= 10;
        if(rest == 5 && (storey%10)>=5){
            answer += 5;
            storey += 1;
        }
        else if(rest > 5){
            answer += (10-rest);
            storey += 1;
        }
        else answer += rest;
        
    }
    return answer;
}