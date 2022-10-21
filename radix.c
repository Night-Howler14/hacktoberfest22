#include<stdio.h>
void countSort(int a[],int n,int pos)
{
    int count[10];
    for(int i=0;i<10;i++)
    {
        count[i]=0;
    }
    for(int i=0;i<n;i++)
    {
        count[(a[i]/pos)%10]++;
    }
    for(int i=1;i<10;i++)
    {
        count[i]+=count[i-1];
    }
    int b[n];
    for(int i=n-1;i>=0;i--)
    {
        b[--count[(a[i]/pos)%10]]=a[i];
    }
    for(int i=0;i<n;i++)
    {
        a[i]=b[i];
    }
}
void radixSort(int a[],int n,int max)
{
    for(int pos=1;(max/pos)>0;pos*=10)
    {
        countSort(a,n,pos);
    }
}
int main()
{
    printf("enter the size of array");
    int n;
    scanf("%d",&n);
    int a[n];
    for(int i=0;i<n;i++)
    {
       printf("enter the element at index %d : ",i+1);
       scanf("%d",&a[i]);
    }
    int max=a[0];
    for(int i=0;i<n;i++)
    {
        if(a[i]>max)
        {
            max=a[i];
        }
    }
    radixSort(a,n,max);
    printf("sorted array : ");
    for(int i=0;i<n;i++)
    {
        printf("%d ",a[i]);
    }

}