#include <iostream>
#include <vector>

using namespace std;
int r, c, t;
int room[51][51];
vector<int> airCleaner;

void Spread() {
	int spread_room[51][51] = { 0, };
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			int curr_room = room[i][j];
			int particle = curr_room / 5;
			if (i > 0 && room[i - 1][j] != -1) {
				spread_room[i - 1][j] += particle;
				curr_room -= particle;
			}
			if (j > 0 && room[i][j - 1] != -1) {
				spread_room[i][j - 1] += particle;
				curr_room -= particle;
			}
			if (i < r - 1 && room[i + 1][j] != -1) {
				spread_room[i + 1][j] += particle;
				curr_room -= particle;
			}
			if (j < c - 1 && room[i][j + 1] != -1) {
				spread_room[i][j + 1] += particle;
				curr_room -= particle;
			}
			spread_room[i][j] += curr_room;
		}
	}
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			room[i][j] = spread_room[i][j];
		}
	}
}

void AirFlow() {
	int cleaner;
	cleaner = airCleaner[0];
	for (int i = cleaner - 1; i > 0; i--) {
		room[i][0] = room[i - 1][0];
	}
	for (int j = 0; j < c - 1; j++) {
		room[0][j] = room[0][j + 1];
	}
	for (int i = 0; i < cleaner; i++) {
		room[i][c - 1] = room[i + 1][c - 1];
	}
	for (int j = c - 1; j > 1; j--) {
		room[cleaner][j] = room[cleaner][j - 1];
	}
	room[cleaner][1] = 0;

	cleaner = airCleaner[1];
	for (int i = cleaner + 1; i < r - 1; i++) {
		room[i][0] = room[i + 1][0];
	}
	for (int j = 0; j < c - 1; j++) {
		room[r-1][j] = room[r-1][j + 1];
	}
	for (int i = r - 1; i > cleaner; i--) {
		room[i][c - 1] = room[i - 1][c - 1];
	}
	for (int j = c - 1; j > 1; j--) {
		room[cleaner][j] = room[cleaner][j - 1];
	}
	room[cleaner][1] = 0;
}

int main() {
	cin >> r >> c >> t;
	int dust;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> dust;
			if (dust == -1) airCleaner.push_back(i);
			room[i][j] = dust;
		}
	}
	for (int i = 0; i < t; i++) {
		Spread();
		AirFlow();
	}
	int sum = 0;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			if (room[i][j] != -1) sum += room[i][j];
		}
	}
	cout << sum;
	return 0;
}
