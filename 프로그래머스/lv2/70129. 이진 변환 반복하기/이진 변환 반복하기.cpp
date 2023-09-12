#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int cnt = 0;
    int num = 1;
    int zero = 0;
    for(auto c : s){
        if(c == '1') cnt++;
        else zero++;
    }
    while(cnt != 1){
        num++;
        int t = 0;
        while(cnt > 1){
            if(cnt%2 == 1) t++;
            else zero++;
            cnt/=2;
        }
        if(cnt == 1) t++;
        cnt = t;
    }
    answer.push_back(num);
    answer.push_back(zero);
    return answer;
}