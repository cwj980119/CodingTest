#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	vector<vector<int>>  v(n + 1, vector<int>());
	vector<bool> visited(n + 1, false);

	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	int cnt = 0;
	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			cnt++;
			queue<int> q;
			visited[i] = true;
			q.push(i);
			int curr;
			while (!q.empty()){
				curr = q.front();
				q.pop();
				for (auto a : v[curr]) {
					if (!visited[a]) {
						visited[a] = true;
						q.push(a);
					}
				}
			}
		}
	}
	cout << cnt;
}