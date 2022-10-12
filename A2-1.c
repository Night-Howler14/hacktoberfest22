#include<stdio.h>
#include<stdlib.h>












int main()
{
    int n,i,j;
    printf("Enter the size for the matrix\n");
    scanf("%d",&n);

    int A[n][n];
    int B[n][n];
    int C[n][n];
    
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            printf("Enter the element for A[%d,%d]",i,j);
            scanf("%d",&A[i][j]);
        }
    }
    printf("\n");
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            printf("Enter the element for B[%d,%d]",i,j);
            scanf("%d",&B[i][j]);
        }
    }


}