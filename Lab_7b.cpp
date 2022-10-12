#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n;
    cout << "enter number of days\n";
    cin >> n;
    int arr[n];
    cout << "enter the profit on each day\n";
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }
    int m = 0;
    int profit = 0;
    int max_profit = 0;
    int buy;
    int sell;
    for (int i = 1; i < n; i++)
    {
        profit = arr[i] - arr[m];
        if (profit > max_profit)
        {
            max_profit = profit;
            sell = i;
            buy = m;
        }
        if (arr[m] > arr[i])
        {
            m = i;
        }
    }
    if (max_profit <= 0)
    {
        cout << "do not buy the stock\n";
    }
    else
    {
        cout << "Buy on : " << buy + 1 << "\n";
        cout << "Sell on : " << sell + 1 << "\n";
        cout << "Profit : " << max_profit << "\n";
    }
}