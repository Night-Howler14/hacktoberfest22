#include <bits/stdc++.h>
using namespace std;

int median(int a[], int n)
{
    sort(a, a + n);
    return a[n / 2];
}

void swap(int *a, int *b)
{
    int temp =*a;
    *a=*b;
    *b=temp;
}

int partition(int a[],int medofmed,int l,int r)
{
    int i;
    for (i = l; i < r; i++)
    {
        if(a[i]==medofmed)
        {
            break;
        }
    }
    swap(&a[i],&a[r]);

    i=l;
    for (int j = l; j < r; j++)
    {
        if(a[j]<=medofmed)
        {
            swap(&a[i],&a[j]);
            i++;
        }
    }
    
    swap(&a[i],&a[r]);
    
    return i;
}

int kth_smallest(int a[], int start, int end, int k)
{
    if(k>0&& k<=end-start+1)
    {
        int n=end-start+1;
        int median[n/5];
        int i;
        for ( i = 0; i < n/5; i++)
        {
            median[i]=median(a+start+i*5,5);
            
        }
        


    }

    return INT_MAX;

}

int main()
{
    int n;
    cin >> n;
    int a[n];

    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    int k;
    cin >> k;

    cout << kth_smallest(a, 0, n - 1, k);

    return 0;
}