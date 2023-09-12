#include <string>
#include <vector>

using namespace std;
int dp[2001];

int fibo(int n){
    if(dp[n]!= 0) return dp[n];
    dp[n] = (fibo(n-1) + fibo(n-2)) % 1234567;
    return dp[n];
}


long long solution(int n) {
    long long answer = 0;
    dp[1] = 1;
    dp[2] = 2;
    answer = fibo(n);
    return answer;
}