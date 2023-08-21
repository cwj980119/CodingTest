#include <iostream>
#include <string>
using namespace std;

char cube[6][9];

enum Side
{
	U, D, F, B, L, R
};

void init_cube() {
	for (int i = 0; i < 6; i++) {
		char c;
		switch (i){
		case 0:
			c = 'w';
			break;	
		case 1:
			c = 'y';
			break;	
		case 2:
			c = 'r';
			break;	
		case 3:
			c = 'o';
			break;	
		case 4:
			c = 'g';
			break;	
		case 5:
			c = 'b';
			break;
		default:
			break;
		}
		for (int j = 0; j < 9; j++) {
			cube[i][j] = c;
		}
	}
}

void print_cube() {
	for (int i = 0; i < 9; i++) {
		cout << cube[0][i];
		if (i % 3 == 2) cout << endl;
	}
}

void leftTurn(int center, int up, int down, int left, int right, int index[4][3]) {
	char temp = cube[center][0];
	cube[center][0] = cube[center][2];
	cube[center][2] = cube[center][8];
	cube[center][8] = cube[center][6];
	cube[center][6] = temp;
	temp = cube[center][1];
	cube[center][1] = cube[center][5];
	cube[center][5] = cube[center][7];
	cube[center][7] = cube[center][3];
	cube[center][3] = temp;

	for (int i = 0; i < 3; i++) {
		char temp = cube[up][index[0][i]];
		cube[up][index[0][i]] = cube[right][index[3][i]];
		cube[right][index[3][i]] = cube[down][index[1][i]];
		cube[down][index[1][i]] = cube[left][index[2][i]];
		cube[left][index[2][i]] = temp;
	}
}

void rightTurn(int center, int up, int down, int left, int right, int index[4][3]) {
	char temp = cube[center][0];
	cube[center][0] = cube[center][6];
	cube[center][6] = cube[center][8];
	cube[center][8] = cube[center][2];
	cube[center][2] = temp;
	temp = cube[center][1];
	cube[center][1] = cube[center][3];
	cube[center][3] = cube[center][7];
	cube[center][7] = cube[center][5];
	cube[center][5] = temp;

	for (int i = 0; i < 3; i++) {
		char temp = cube[up][index[0][i]];
		cube[up][index[0][i]] = cube[left][index[2][i]];
		cube[left][index[2][i]] = cube[down][index[1][i]];
		cube[down][index[1][i]] = cube[right][index[3][i]];
		cube[right][index[3][i]] = temp;
	}
}

int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		init_cube();
		int j;
		cin >> j;
		for (int k = 0; k < j; k++) {
			string s;
			cin >> s;
			if (s == "U+") {
				int index[4][3] = {
					{0,1,2},
					{0,1,2},
					{0,1,2},
					{0,1,2}
				};
				rightTurn(U, B, F, L, R, index);
			}
			else if (s == "U-") {
				int index[4][3] = {
					{0,1,2},
					{0,1,2},
					{0,1,2},
					{0,1,2}
				};
				leftTurn(U, B, F, L, R, index);
			}
			else if (s == "D+") {
				int index[4][3] = {
					{8,7,6},
					{8,7,6},
					{8,7,6},
					{8,7,6}
				};
				rightTurn(D, F, B, L, R, index);
			}
			else if (s == "D-") {
				int index[4][3] = {
					{8,7,6},
					{8,7,6},
					{8,7,6},
					{8,7,6}
				};
				leftTurn(D, F, B, L, R, index);
			}
			else if (s == "F+") {
				int index[4][3] = {
					{8,7,6},
					{0,1,2},
					{2,5,8},
					{6,3,0}
				};
				rightTurn(F, U, D, L, R, index);
			}
			else if (s == "F-") {
				int index[4][3] = {
					{8,7,6},
					{0,1,2},
					{2,5,8},
					{6,3,0}
				};
				leftTurn(F, U, D, L, R, index);
			}
			else if (s == "B+") {
				int index[4][3] = {
					{0,1,2},
					{8,7,6},
					{2,5,8},
					{6,3,0}
				};
				rightTurn(B, U, D, R, L, index);
			}
			else if (s == "B-") {
				int index[4][3] = {
					{0,1,2},
					{8,7,6},
					{2,5,8},
					{6,3,0}
				};
				leftTurn(B, U, D, R, L, index);
			}
			else if (s == "L+") {
				int index[4][3] = {
					{6,3,0},
					{6,3,0},
					{2,5,8},
					{6,3,0}
				};
				rightTurn(L, U, D, B, F, index);
			}
			else if (s == "L-") {
				int index[4][3] = {
					{6,3,0},
					{6,3,0},
					{2,5,8},
					{6,3,0}
				};
				leftTurn(L, U, D, B, F, index);
			}
			else if (s == "R+") {
				int index[4][3] = {
					{2,5,8},
					{2,5,8},
					{2,5,8},
					{6,3,0}
				};
				rightTurn(R, U, D, F, B, index);
			}
			else if (s == "R-") {
				int index[4][3] = {
					{2,5,8},
					{2,5,8},
					{2,5,8},
					{6,3,0}
				};
				leftTurn(R, U, D, F, B, index);
			}
		}
		print_cube();
	}
}