#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;
map<int, int>m;
vector<int> v1, v2;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n;
	int x;
	cin >> n;
	int count = 0;
	for (int i = 0; i < n; i++) {
		cin >> x;
		v1.push_back(x);
		v2.push_back(x);
	}
	sort(v1.begin(),v1.end());
	int before = NULL;
	for (int i = 0; i < v1.size(); i++) {
		if (before == v1[i]) continue;
		m.insert(pair<int, int>(v1[i], count++));
		before = v1[i];
	}
	for (int i = 0; i < v2.size(); i++) {
		cout << m.find(v2[i])->second << " ";
	}
}