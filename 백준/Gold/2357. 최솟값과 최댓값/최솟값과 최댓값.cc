#include <iostream>
#include <vector>
#define SIZE 2097153
#define DIV 1000000007

using namespace std;

typedef struct st1 {
	int min = DIV;
	int max = 0;
} NODE;

int myMin(int a, int b) {
	return a < b ? a : b;
}

int myMax(int a, int b) {
	return a > b ? a : b;
}

NODE seg_tree[SIZE];

void init(int idx, int e) {
	
	while (true) {
		for (int i = 0; i <= e; i++) {
			seg_tree[idx + i].min = myMin(seg_tree[(idx + i) * 2].min, seg_tree[(idx + i) * 2 + 1].min);
			seg_tree[idx + i].max = myMax(seg_tree[(idx + i) * 2].max, seg_tree[(idx + i) * 2 + 1].max);
		}
		if (idx == 0) break;
		idx /= 2;
		e /= 2;
	}
}

int getSubMax(int s, int e, int x, int y, int index) {
	if (s <= x && y <= e) return seg_tree[index].max;
	if (s > y || e < x) return 0;
	return myMax(getSubMax(s, e, x, (x + y) / 2, index * 2), getSubMax(s, e, (x + y) / 2 + 1, y, index * 2 + 1));
}

int getSubMin(int s, int e, int x, int y, int index) {
	if (s <= x && y <= e) return seg_tree[index].min;
	if (s > y || e < x) return DIV;
	return myMin(getSubMin(s, e, x, (x + y) / 2, index * 2), getSubMin(s, e, (x + y) / 2 + 1, y, index * 2 + 1));
}

int main() {
	ios::sync_with_stdio(NULL);
	cin.tie(NULL);

	int n, m;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		int value;
		cin >> value;
		seg_tree[SIZE / 2 + i].min = seg_tree[SIZE / 2 + i].max = value;
	}

	init(SIZE / 4, n/2);

	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		int max = getSubMax(a - 1, b - 1, 0, SIZE / 2 - 1, 1);
		int min = getSubMin(a - 1, b - 1, 0, SIZE / 2 - 1, 1);
		cout << min << " " << max << "\n";
	}

	return 0;
}