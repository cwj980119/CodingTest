#include <iostream>
using namespace std;
int zero, one;

class memo {
public:
	bool cal=false;
	int zero = 0;;
	int one = 0;;
};
memo table[41];
void fibonacci(int n) {
	if (table[n].cal) {
		return;
	}
	if (n == 0) {
		table[n].cal = true;
		table[n].zero++;
	}
	else if (n == 1) {
		table[n].cal = true;
		table[n].one++;
	}
	else {
		if (table[n - 1].cal && table[n - 2].cal) {
		}
		else if (table[n - 2].cal) {
			fibonacci(n - 1);
		}
		else {
			fibonacci(n - 1);
			fibonacci(n - 2);
		}
		table[n].cal = true;
		table[n].zero = table[n - 1].zero + table[n - 2].zero;
		table[n].one = table[n - 1].one + table[n - 2].one;
		
	}
}
int main() {
	int n, m;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &m);
		zero = one = 0;
		fibonacci(m);
		printf("%d %d\n", table[m].zero, table[m].one);
	}
}