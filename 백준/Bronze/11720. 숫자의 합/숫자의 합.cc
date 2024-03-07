#include<iostream>
#include<string>

using namespace std;

int main() {
	int N;
	cin >> N;
	string input;
	cin >> input;

	int result = 0;

	for (int i = 0; i < input.length(); i++)
	{
		result += input[i] - 48;
	}

	cout << result << endl;
}