#include <iostream>
using namespace std;

int main()
{
	int a, b, number;
	cin >> a >> b >> number;
	int arr[number];
	if (number == 1)
		return a;
	else if (number == 2)
		return b;
	arr[1] = a;
	arr[2] = b;

	for (int i = 3; i <= number; i++)
	{
		arr[i] = arr[i - 1] - arr[i - 2];
	}
	printf("%d", arr[number]);
}