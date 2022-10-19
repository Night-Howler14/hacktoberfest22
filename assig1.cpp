#include <bits/stdc++.h>
using namespace std;

int binarySearch(int d[], int element, int n)
{
    int low = 0, high = n - 1;
    int mid;
    while (high - low > 1)
    {
        mid = (high + low) / 2;
        if (d[mid] > element)
            high = mid - 1;
        else
            low = mid;
    }
    if (d[high] <= element)
        return high;
    else if (d[low] <= element)
        return low;
    else
        return -1;
}

void swap(int *a, int *b)
{
    int temp = *a;
    *a = *b;
    *b = temp;
}

int partition(int a[], int low, int high)
{
    int pivot = a[high];
    int i = (low - 1);

    for (int j = low; j <= high - 1; j++)
    {
        if (a[j] < pivot)
        {
            i++;
            swap(&a[i], &a[j]);
        }
    }
    swap(&a[i + 1], &a[high]);
    return (i + 1);
}

void quickSort(int a[], int low, int high)
{
    if (low < high)
    {
        int pi = partition(a, low, high);
        quickSort(a, low, pi - 1);
        quickSort(a, pi + 1, high);
    }
}

int main()
{
    cout << "Enter number of petrol pumps : " << endl;
    int n;
    cin >> n;
    cout << "Enter the distances of each petrol pump : " << endl;
    int d[n];
    for (int i = 0; i < n; i++)
    {
        cin >> d[i];
    }
    cout << "Enter fuel capacity of the car : " << endl;
    int c;
    cin >> c;

    quickSort(d, 0, n); // sorting distances in increasing order

    bool flag = 1;
    for (int i = 1; i < n; i++)
    {
        if (d[i] - d[i - 1] > c)
        {
            flag = 0;
            break;
        }
    }

    if (flag == 0)
    {
        cout << "Not possible to reach Kolkata to reach Bongora." << endl;
    }
    else
    {
        int pos = 0;   // stores index for last petral pump used
        int count = 0; // stores number of petrol pumps visited
        cout << "Positions of petrol pumps visited : " << endl;
        while (pos != n - 1)
        {
            cout << d[pos] << " ";
            pos = binarySearch(d, d[pos] + c, n);
            count++;
        }
        cout << endl;
        cout << "Minumum number of stops (for filling petrol) : " << count << endl;
    }

    return 0;
}