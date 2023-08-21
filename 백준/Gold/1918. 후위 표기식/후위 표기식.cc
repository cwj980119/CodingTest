#include <iostream>
#include <stack>


using namespace std;
stack<char> s;

void pop_all(bool bracket) {
	char curr;
	while (!s.empty()) {
		curr = s.top();
		s.pop();
		if (curr == '(') {
			if (!bracket) s.push('(');
			break;
		}
		cout << curr;
	}
	return;
}

int main() {
	string infix;
	cin >> infix;
	char next;
	for (int i = 0; i < infix.size(); i++) {
		next = infix[i];
		if ('A' <= next && next <= 'Z') {
			cout << next;
		}
		else if (next == '*' || next == '/') {
			if (!s.empty() && (s.top() == '*' || s.top() == '/')) {
				cout << s.top();
				s.pop();
			}
			s.push(next);
		}
		else if (next == '+' || next == '-') {
			pop_all(false);
			s.push(next);
		}
		else if (next == '(') s.push(next);
		else if (next == ')') pop_all(true);
	}
	pop_all(true);

	return 0;
}
