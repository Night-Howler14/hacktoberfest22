#include<stdio.h>
#include<stdbool.h>
int n;
bool isSafe(int board[][n],int row,int col)
{
  for(int j=0;j<n;j++)
  {
    if(board[row][j]==1)
    return false;
  }
  for(int i=0;i<n;i++)
  {
    if(board[i][col]==1)
    return false;
  }
  int r=row,c=col;
  while(r>=0 && c>=0)
  {
    if(board[r][c]==1)
    return false;
    r--;c--;
  }
  r=row,c=col;
  while(r>=0 && c<n)
  {
    if(board[r][c]==1)
    return false;
    r--;c++;
  }
   r=row,c=col;
  while(r<n && c>=0)
  {
    if(board[r][c]==1)
    return false;
    r++;c--;
  }
   r=row,c=col;
  while(r<n && c<n)
  {
    if(board[r][c]==1)
    return false;
    r++;c++;
  }
  return true;
}
bool nQueen(int board[][n],int row)
{
    if(row>=n)
    {
         for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            printf("%d ",board[i][j]);
        }
            printf("\n");
    }
            printf("\n");
    }
    for(int j=0;j<n;j++)
    {
        if(isSafe(board,row,j))
        {
            board[row][j]=1;
            if(nQueen(board,row+1))
            {

            return true;
            }
            board[row][j]=0;
        }

    }
    return false;

}
int main()
{
    printf("enter the number of queens : ");
    scanf("%d",&n);
    int board[n][n];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            board[i][j]=0;
        }
    }
    nQueen(board,0);
    

}