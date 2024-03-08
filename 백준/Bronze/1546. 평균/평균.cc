#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	float input;
	cin >> input;
	float arr[1001] = { 0 };
	int result = 0;
	float temp = 0;

	for (int i = 0; i < input; i++) {
		int num;
		cin >> num;
		arr[i] = num;
	}

	for (int i = 0; i < input; i++) {
		if(temp < arr[i]) temp = arr[i];
		result += arr[i];
	}

	cout << result * 100 / temp / input << endl;

	return 0;
}
