#include <bits/stdc++.h>
using namespace std;

void merge(int dist[], string pp[], int lb, int mid, int ub)
{
    int i, j, k;
    int n1 = mid - lb + 1;
    int n2 = ub - mid;

    int L1[n1], R1[n2];
    string L2[n1], R2[n2];

    for (i = 0; i < n1; i++)
    {
        L1[i] = dist[lb + i];
        L2[i] = pp[lb + i];
    }
    for (j = 0; j < n2; j++)
    {
        R1[j] = dist[mid + 1 + j];
        R2[j] = pp[mid + 1 + j];
    }
    i = 0;
    j = 0;
    k = lb;
    while (i < n1 && j < n2)
    {
        if (L1[i] <= R1[j])
        {
            dist[k] = L1[i];
            pp[k] = L2[i];
            i++;
        }
        else
        {
            dist[k] = R1[j];
            pp[k] = R2[j];
            j++;
        }
        k++;
    }

    while (i < n1)
    {
        dist[k] = L1[i];
        pp[k] = L2[i];
        i++;
        k++;
    }

    while (j < n2)
    {
        dist[k] = R1[j];
        pp[k] = R2[j];
        j++;
        k++;
    }
}

void merge_sort(int dist[], string pp[], int lb, int ub)
{
    if (lb < ub)
    {
        int mid = (lb + ub) / 2;
        merge_sort(dist, pp, lb, mid);
        merge_sort(dist, pp, mid + 1, ub);
        merge(dist, pp, lb, mid, ub);
    }
}

int main()
{
    int c;
    cout << "Enter the fuel capacity: ";
    cin >> c;
    int n;
    cout << "Enter the number of petrol pumps: ";
    cin >> n;
    string pp[n];
    int dist[n];
    cout << "enter the petrol pumps\n";
    for (int i = 0; i < n; i++)
    {
        cin >> pp[i];
    }
    cout << "Enter theirs distances\n";
    for (int i = 0; i < n; i++)
    {
        cin >> dist[i];
    }
    int flag = 1;
    merge_sort(dist, pp, 0, n - 1);
    for (int i = 0; i < n - 1; i++)
    {
        if (dist[i + 1] - dist[i] > c)
        {
            flag = 0;
            break;
        }
    }
    if (flag == 0)
    {
        cout << "Not possible to reach the destination\n";
        cout << "The maximum petrol pump you can reach is : \n";
    }
    cout << "(p0,0) ";
    int pos = 0;
    for (int i = 0; i < n; i++)
    {
        if (dist[i] - pos > c)
        {
            cout << "(" << pp[i - 1] << "," << dist[i - 1] << ")"
                 << " ";
            pos = dist[i - 1];
        }
    }
}