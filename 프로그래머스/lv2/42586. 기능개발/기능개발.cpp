#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> progresses, vector<int> speeds) {
    vector<int> answer;
    int length = progresses.size();
    int curr = 0;
    while(curr < length){
        int start = curr;
        for(int i = start; i<length;i++){
            progresses[i]+=speeds[i];
        }
        for(int i = start; i<length;i++){
            if(progresses[i]<100){
                if(i-start > 0) {
                    answer.push_back(i-start);
                }
                curr = i;
                break;
            }
            if(i == length-1){
                answer.push_back(length-start);
                curr = length;
                break;
            }
        }
    }
    
    return answer;
}