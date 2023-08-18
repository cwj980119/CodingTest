#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

bool dfs_visited[1001] = { false };
bool bfs_visited[1001] = { false };
vector<vector<int>> v(1001, vector<int>());

void dfs(int curr) {
	if (dfs_visited[curr]) return;
	dfs_visited[curr] = true;
	cout << curr << ' ';
	for (int k : v[curr]) {
		dfs(k);
	}
}

void bfs(int start) {
	int curr;
	queue<int> q;
	bfs_visited[start] = true;
	q.push(start);
	while (!q.empty()) {
		curr = q.front();
		q.pop();
		cout << curr << ' ';
		for (int c : v[curr]) {
			if (!bfs_visited[c]) { 
				bfs_visited[c] = true;
				q.push(c); 
			}
		}
	}
}

int main() {
	int n, m, start;
	cin >> n >> m >> start;
	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for (vector<int> &vi : v) {
		sort(vi.begin(), vi.end());
	}
	dfs(start);
	cout << endl;
	bfs(start);
}