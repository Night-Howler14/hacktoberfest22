#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int n;
int *mul(int *x,int *y,int n){
    int z=(int)malloc(n*n*sizeof(int));
    if(n==1){
        z=(*x)(*y);
    }
    else{
        int mid=n/2;
        add(z,mul(x,y,mid),mul(x+mid,y+(n*mid),mid),n,mid);
        add(z+mid,mul(x,y+mid,mid),mul(x+mid,y+(n*mid)+mid,mid),n,mid);
        add(z+n*mid,mul(x+n*mid,y,mid),mul(x+mid+(n*mid),y+(n*mid),mid),n,mid);
        add(z+n*mid+mid,mul(x+n*mid,y+mid,mid),mul(x+mid+(mid*n),y+(n*mid)+mid,mid),n,mid);
    }
    return z;
}

int add(int *z, int *x, int *y, int n, int mid){
    for(int i=0;i<mid;i++){
        for(int j=0;j<n;j++){
            (z+n*i+j)=(x+mid*i+j)+*(y+mid*i+j);
        }
    }
}

int main(){
    printf("enter the size of matrix: ");
    scanf("%d",&n);
    int x[n][n], y[n][n];
    printf("enter elements of first matrix: \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("enter element x[%d][%d]: ",i,j);
            scanf("%d",&x[i][j]);
        }
    }
    printf("enter elements of second matrix: \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("enter element y[%d][%d]: ",i,j);
            scanf("%d",&y[i][j]);
        }
    }
    int *z=mul(*x,*y,n);
    printf("\nthe product of the two matrices is: \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            printf("%d ",*(z+n*i+j));
        }
        printf("\n");
    }
    /*print(a);
    printf("\n");
    print(y);*/
}