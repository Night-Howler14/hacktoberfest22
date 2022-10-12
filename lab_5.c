#include <stdio.h>
#include <limits.h>
void Merge(int arr[], int lb, int mid, int ub)
{
    int n1 = mid - lb + 1, n2 = ub - mid;
    int L[n1], R[n2];
    int i, j, k;
    for (i = 0; i < n1; i++)
    {
        L[i] = arr[lb + i];
    }
    for (j = 0; j < n2; j++)
    {
        R[j] = arr[mid + 1 + j];
    }
    i = 0;
    j = 0;
    k = lb;

    while (i < n1 && j < n2)
    {
        if (L[i] >= R[j])
        {
            arr[k] = L[i];
            i++;
        }
        else
        {
            arr[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1)
    {
        arr[k] = L[i];
        i++;
        k++;
    }

    while (j < n2)
    {
        arr[k] = R[j];
        j++;
        k++;
    }
}
void mergeSort(int arr[], int lb, int ub)
{
    if (lb < ub)
    {
        int mid = (lb + ub) / 2;
        mergeSort(arr, lb, mid);
        mergeSort(arr, mid + 1, ub);
        Merge(arr, lb, mid, ub);
    }
}
int main()
{
    printf("enter the number of coins denominations : ");
    int n;
    scanf("%d", &n);
    int coin[n];
    int i;

    // printf("Please enter denominations: \n");
    // for (i = 0; i < n; i++)
    // {
    //     printf("coin %d : ", i + 1);
    //     scanf("%d", &coin[i]);
    // }

    printf("Please enter denominations: \n");
    for (i = 0; i < n; i++)
    {
        scanf("%d", &coin[i]);
    }

    printf("Please enter the amount you want to change: ");
    int V, v;
    scanf("%d", &V);
    v = V;
    mergeSort(coin, 0, n - 1);
    int coinCount[n];
    for (i = 0; i < n; i++)
    {
        coinCount[i] = 0;
    }
    int q, r, flag = 0, m, j;
    i = 0;
    while (i < n)
    {
        q = v / coin[i];
        coinCount[i] = q;
        v = v % coin[i];
        i++;
    }
    if (v != 0)
    {

        printf("No Denominations possible ");
    }
    else
    {
        printf("Your Denominations : ");
        for (i = 0; i < n; i++)
        {
            if (coinCount[i] != 0)
            {
                printf("%d X %d ,", coin[i], coinCount[i]);
            }
        }
    }
}