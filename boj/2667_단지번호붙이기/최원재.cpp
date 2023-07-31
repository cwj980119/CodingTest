#include <iostream>
#include <vector>
#include <string>
#include <queue>

using namespace std;

vector<string> v;
vector<vector<bool>> visited;
int n;
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

int bfs(int x, int y) {
	queue<pair<int,int>> q;
	visited[x][y] = true;
	q.push(make_pair(x, y));
	pair<int, int> cur;
	int nx, ny;
	int cnt = 0;
	while (!q.empty()){
		cnt++;
		cur = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			nx = cur.first + dx[i];
			ny = cur.second + dy[i];
			if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
			if (v[nx][ny] == '1' && !visited[nx][ny]) {
				q.push(make_pair(nx, ny));
				visited[nx][ny] = true;
			}
		}
	}
	return cnt;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n;
	visited.resize(n+1, vector<bool>(n+1));
	string s;
	for (int i = 0; i <n; ++i) {
		cin >> s;
		v.push_back(s);
	}

	priority_queue<int, vector<int>> pq;
	
	for (int i = 0; i < n; ++i) {
		for (int j = 0; j < n; ++j) {
			if (v[i][j] == '1' && !visited[i][j]) pq.push(0-bfs(i, j));
		}
	}
	int len = pq.size();
	cout << len << '\n';
	for (int i = 0; i < len; i++) {
		cout << 0 - pq.top() << '\n';
		pq.pop();
	}
}
