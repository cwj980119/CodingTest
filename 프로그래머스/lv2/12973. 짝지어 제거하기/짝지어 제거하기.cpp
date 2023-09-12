#include <iostream>
#include <string>
#include <stack>
using namespace std;

int solution(string s)
{
    int answer = -1;
    stack<char> stack;
    for(auto c : s){
        if(!stack.empty()){
            if(stack.top() == c) {
                stack.pop();
                continue;
            }
        }
        stack.push(c);
    }
    if(stack.empty()) answer = 1;
    else answer = 0;
    return answer;
}