#include<stdio.h>

void insertheap(int a[],int n){
    int temp,i=n;
    temp = a[n];
    while(i>1 && temp>a[i/2]){
        a[i] = a[i/2];
        i = i/2;
    }
    a[i] = temp;
}

int delete(int a[],int n){
    int i,j,x,temp,val;
    val = a[1];
    x = a[n];
    a[1] = a[n];
    i=1;j=2*i;

    while(j<n-1){
        if(a[j+1]>a[j]){
            j = j+1;
        }
        if(a[i]<a[j]){
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i=j;
            j = j*2;
        }
        else
        break;
    }
    return val;
}
int main(){


    int a[] = {0,10,20,30,25,5,40,35};
    int b[7];

    for(int i=2;i<=7;i++){
        insertheap(a,i);
    }

    for(int i=1;i<=7;i++){
        printf("%d\t",a[i]);
    }

    printf("\n");

    for(int i = 8;i>0;i--){
        b[8-i] = delete(a,i+1);
    }
    for(int i = 0;i<7;i++){
        printf("%d\t",b[i]);
    }

    return 0;
}