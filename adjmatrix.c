#include<stdio.h>
int main()
{
    printf("enter the number of vertices : ");
    int v;
    scanf("%d",&v);
    printf("enter the number of edges : ");
    int e;
    scanf("%d",&e);
    int adjmat[v+1][v+1];
    int i,j;
    for( i=0;i<v+1;i++)
    {
        for(j=0;j<v+1;j++)
        {
            adjmat[i][j]=0;
        }
    }
    int x,y;
    for(i=0;i<e;i++)
    {
        printf("enter for edge %d : ",i+1);
        scanf("%d %d",&x,&y);
        adjmat[x][y]=1;
        adjmat[y][x]=1;

    }
    for( i=1;i<v+1;i++)
    {
        for(j=1;j<v+1;j++)
        {
            printf("%d ",adjmat[i][j]);
        }
        printf("\n");
    }


}