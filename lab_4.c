#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <math.h>

void swap(int*a, int *b){
    int temp=*a;
    *a=*b;
    *b=temp;
}
int main(){
    int n;
    printf("enter the number of jobs: ");
    scanf("%d", &n);
    int arr[n][2];
    for(int i=0;i<n;i++){
        printf("enter start time and end time for job %d: \n",i+1);
        scanf("%d",&arr[i][0]);
        scanf("%d",&arr[i][1]);
    }

    int con[n];
    int conflicts;
    for(int i=0;i<n;i++){
        conflicts=0;
        for(int j=0;j<n;j++){
            if(arr[i][1]>arr[j][0] && arr[i][0]<arr[j][1]){
                conflicts++;
            }
        }
        printf("the number of conflicts for job %d are: %d\n",i+1,conflicts-1);
        con[i]=conflicts-1;
    }

    int max=con[0],min=con[0],maxind=0,minind=0;
    for(int i=0;i<n;i++){
        if(con[i]>max){
            max=con[i];
            maxind=i;
        }
    }
    for(int j=0;j<n;j++){
        if(con[j]<min){
            min=con[j];
            minind=j;
        }
    }
    printf("\n");
    printf("job %d has maximum conflicts i.e. %d\n",maxind+1,max);
    printf("job %d has minimum conflicts i.e. %d\n",minind+1,min);
    printf("\n");

    int k;
    for(int i=0;i<n;i++){
        for(int j=0;j<n-i-1;j++){
            for(int k=0;k<2;k++){
                if(arr[j][1]>arr[j+1][1]){
                swap(&arr[j][k],&arr[j+1][k]);
                }
            }
        }
    }
    
    int b[n][2];
    for(int i=0;i<n;i++){
        for(int j=0;j<2;j++){
            b[i][j]=-1;
        }
    }
    for(int i=0;i<2;i++){
        b[0][i]=arr[0][i];
    }
    int q=0;
    for(int i=1;i<n;i++){
        if(arr[i][0]>=b[q][1]){
            q++;
            for(int j=0;j<2;j++){
                b[q][j]=arr[i][j];
            }
        }
    }
    printf("the set of jobs which can be scheduled without conflict are: \n");
    for(int i=0;i<n;i++){
        for(int j=0;j<2;j++){
            if(b[i][j]!=-1){
                printf("%d ",b[i][j]);
            }
        }
        printf("\n");
    }
    
}