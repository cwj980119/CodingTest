#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;
vector < vector<pair<int, int>>> road;
vector<int> dist;
bool visited[1001];
int x;

struct cmp {
	bool operator()(pair<int, int> a, pair<int, int> b) {
		return a.second > b.second;
	}
};

void ToParty(int start) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
	memset(visited, false, sizeof(visited));
	pq.push(make_pair(start, 0));

	int curr, curr_dist;
	while (!pq.empty()) {
		curr = pq.top().first;
		curr_dist = pq.top().second;
		pq.pop();
		if (curr == x) {
			dist[start] += curr_dist;
			return;
		}
		if (visited[curr]) continue;
		visited[curr] = true;
		for (pair<int, int> p : road[curr]) {
			pq.push(make_pair(p.first, p.second + curr_dist));
		}
	}
	return;
}

void ToHome() {
	priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;
	memset(visited, false, sizeof(visited));
	pq.push(make_pair(x, 0));

	int curr, curr_dist;
	while (!pq.empty()) {
		curr = pq.top().first;
		curr_dist = pq.top().second;
		pq.pop();
		if (visited[curr]) continue;
		visited[curr] = true;
		dist[curr] += curr_dist;
		for (pair<int, int> p : road[curr]) {
			pq.push(make_pair(p.first, p.second + curr_dist));
		}
	}
	return;
}

int main() {
	int n, m;
	cin >> n >> m >> x;
	road.assign(n + 1, vector<pair<int, int>>());
	dist.assign(n + 1, 0);
	int a, b, c;
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		road[a].push_back(make_pair(b, c));
	}

	for (int i = 1; i <= n; i++) {
		ToParty(i);
	}
	ToHome();
	
	int max = -1;
	for (int d : dist) {
		if (max < d) max = d;
	}
	cout << max;

	return 0;
}
