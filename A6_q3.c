#include <stdio.h>
#include <limits.h>



int matrix_chain3(int p[], int n)      //matrix chain multipliction by iterative approach 
{
    int T_cost[n + 1][n + 1];

    int i, j, k, L, cost, mincost, optimal_k;
    for (i = 1; i <= n; i++)
        T_cost[i][i] = 0;

    for (L = 2; L <= n; L++)
    {
        for (i = 1; i <= n - L + 1; i++)
        {
            j = i + L - 1;
            T_cost[i][j] = INT_MAX;
            mincost = INT_MAX;
            optimal_k = j;
            for (k = i; k <= j - 1; k++)
            {
                cost = T_cost[i][k] + T_cost[k + 1][j] + p[i - 1] * p[k] * p[j];
                if (cost < mincost)
                {
                    mincost = cost;
                    optimal_k = j;
                }
            }
            T_cost[i][j] = mincost;
        }
    }

    return T_cost[1][n];
}

int main()
{
    int n;
    printf("Enter the number of matrix: ");
    scanf("%d", &n);
    int arr[n + 1];

    for (int i = 0; i < n + 1; i++)
    {
        if (i == n)
        {
            printf("enter col size of matrix %d: ", i);
            scanf("%d", &arr[i]);
        }
        else
        {
            printf("enter row size of matrix %d: ", i + 1);
            scanf("%d", &arr[i]);
        }
    }

   

    int cost3[n][n];
    int par[n][n];
    for (int i = 0; i <= n; i++)
    {
        for (int j = 0; j <= n; j++)
        {
            par[i][j] = 0;
        }
    }
    printf("\nMinimum cost of matrix multiplication by iterative approach is:%d \n", matrix_chain3(arr, n));

    return 0;
}