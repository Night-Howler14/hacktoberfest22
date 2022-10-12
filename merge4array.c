#include <stdio.h>
#include <stdlib.h>
int bisearch(int *arr, int k, int low, int high)
{

    if (low > high)
    {
        return 0;
    }
    int mid;
    mid = (low + high) / 2;
    if (k > arr[mid])
    {
        low = mid + 1;
        bisearch(arr, k, low, high);
    }
    else if (k < arr[mid])
    {
        high = mid - 1;
        bisearch(arr, k, low, high);
    }
    else if (arr[mid] == k)
    {
        return mid;
    }
}
void merge(int *arr, int p, int q, int r)
{
    int l[100] = {}, m[100] = {}, s[100] = {}, g[100] = {},brr[100]={},crr[100]={};
    int n1, n2, n3, n4;
    int e, j;
    e = (p + q) / 2;
    j = ((q + 1) + r) / 2;
    n1 = (e - p + 1);
    n2 = (q - e);
    n3 = (j - (q + 1) + 1);
    n4 = (r - j);
    int k;
    k = p;
    for (int i = 0; i < n1; i++)
    {
        l[i] = arr[k];
        k++;
    }
    int t = e + 1;
    for (int i = 0; i < n2; i++)
    {
        m[i] = arr[t];
        t++;
    }
    int f = q + 1;
    for (int i = 0; i < n3; i++)
    {
        s[i] = arr[f];
        f++;
    }
    int d = j + 1;
    for (int i = 0; i < n4; i++)
    {
        g[i] = arr[d];
        d++;
    }
    int temp = 0;
    int n = 0;
    k = 0;
    while (temp < n1 && n < n2)
    {
        if (l[temp] < m[n])
        {
            brr[k] = l[temp];
            temp++;
            k++;
        }
        else if (l[temp] == m[n])
        {

            brr[k] = l[temp];
            temp++;
            k++;
        }
        else
        {
            brr[k] = m[n];
            n++;
            k++;
        }
    }
    while (temp < n1)
    {
        brr[k] = l[temp];
        k++;
        temp++;
    }

    while (n < n2)
    {
        brr[k] = m[n];
        k++;
        n++;
    }
    temp = 0;
    n = 0;
    k=0;
    while (temp < n3 && n < n4)
    {
        if (l[temp] < m[n])
        {
            crr[k] = l[temp];
            temp++;
            k++;
        }
        else if (l[temp] == m[n])
        {

            crr[k] = l[temp];
            temp++;
            k++;
        }
        else
        {
            crr[k] = m[n];
            n++;
            k++;
        }
    }
    while (temp < n3)
    {
        crr[k] = l[temp];
        k++;
        temp++;
    }

    while (n < n4)
    {
        crr[k] = m[n];
        k++;
        n++;
    }
    
}
void mergesort(int *arr, int p, int r)
{

    if (p < r)
    {
        int q;
        q = (p + r) / 2;
        mergesort(arr, p, q);
        mergesort(arr, q + 1, r);
        merge(arr, p, q, r);
    }
}
int main()
{
    int *arr;
    int n;
    scanf("%d", &n);
    int k;
    scanf("%d", &k);
    arr = (int *)malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &arr[i]);
    }
    mergesort(arr, 0, n - 1);
    for (int i = 0; i < n; i++)
    {
        printf("%d ", arr[i]);
    }
    printf("\n");
}
