#include <iostream>
#include <queue>

using namespace std;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int n, m, a;
	cin >> n >> m;
	priority_queue<long long, vector<long long>> pq;
	for(int i =0; i<n;i++){
		cin >> a;
		pq.push(-a);
	}
	long long x, y;
	for (int i = 0; i < m; i++) {
		x = pq.top();
		pq.pop();
		y = pq.top();
		pq.pop();
		pq.push(x + y);
		pq.push(x + y);
	}
	long long sum = 0;
	int len = pq.size();
	for (int i = 0; i < len; i++) {
		sum -= pq.top();
		pq.pop();
	}
	cout << sum;
}
