#include <iostream>
#include <vector>
#define SIZE 2097153

using namespace std;

long long seg_tree[SIZE];

void init(int idx, int e) {
	
	while (true) {
		for (int i = 0; i <= e; i++) {
			seg_tree[idx + i]= seg_tree[(idx + i) * 2] + seg_tree[(idx + i) * 2 + 1];
		}
		if (idx == 0) break;
		idx /= 2;
		e /= 2;
	}
}

void update(long long num, long long changed) {
	int idx = SIZE / 2;
	seg_tree[idx + num] = changed;
	idx /= 2;
	num /= 2;
	while (true) {
		seg_tree[idx + num] = seg_tree[(idx + num) * 2]+ seg_tree[(idx + num) * 2 + 1];
		if (idx == 0) break;
		idx /= 2;
		num /= 2;
	}
}

long long getSubSum(int s, int e, int x, int y, int index) {
	if (s <= x && y <= e) return seg_tree[index];
	if (s > y || e < x) return 0;
	return getSubSum(s, e, x, (x + y) / 2, index * 2) + getSubSum(s, e, (x + y) / 2 + 1, y, index * 2 + 1);


}

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(NULL);

	long long n, m, k;
	cin >> n >> m >> k;

	for (int i = 0; i < n; i++) {
		cin >> seg_tree[SIZE / 2 + i];
	}

	init(SIZE / 4, n/2);

	long long a, b, c;
	for (int i = 0; i < m + k; i++) {
		cin >> a >> b >> c;
		if (a == 1) update(b - 1, c);
		else {
			long long answer = getSubSum(b-1, c-1, 0, SIZE/2-1, 1);
			cout << answer << endl;
		}
	}

	return 0;
}