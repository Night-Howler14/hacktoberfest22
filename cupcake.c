#include<stdio.h>
#include<math.h>

//calorie intake has to be sorted
void merge(int arr[], int low, int mid, int high)
{
  int mid1 = mid + 1 - low;
  int mid2 = high - mid;
  //temp arrays to copy elements  
  int P[mid1];
  int Q[mid2];
  //copying elements from 0 to mid into P
  for(int i = 0; i < mid1; i++) 
  {
    P[i] = arr[low + i];
  }
  //copying elements from mid+1 to (mid+1+high-mid-1)=(high) to Q
  for(int j = 0; j < mid2; j++)
  {
    Q[j] = arr[mid + 1 + j];
  }
  //initializing i,j,k for iterating through P,Q,arr respectively
  int i = 0, j = 0, k = low;
  //merging P and Q by comparing every element and entering elements into the original array 
  while(i < mid1 && j < mid2)
  {
    if(P[i] <= Q[j])
    {
      arr[k] = P[i];
      i++;
    }
    else
    {
      arr[k] = Q[j];
      j++;
    }
    k++;
  }
  //other elements of P, if left; is copied into the original array 
  while(i < mid1)
  {
    arr[k] = P[i];
    i++;
    k++;
  }
  //other elements of Q, if left; is copied into the original array 
  while(j < mid2)
  {
    arr[k] = Q[j];
    j++;
    k++;
  }
}
//merge sort to get the sorted array 
void mergesort(int arr[], int low, int high)
{
  if(low < high)
  {
    int mid = (low + high) / 2;
    mergesort(arr, low, mid);
    mergesort(arr, mid+1, high);
    merge(arr, low, mid, high);
  }
}

void miles_count(int arr[],int n)
{
  //sort the calorie intake array
    mergesort(arr,0,n-1);
    printf("The sorted calorie count array: ");
    for(int i = 0; i < n; i++)
    {
      printf(" %d ", arr[i]);
    }
    printf("\n");
    //to minimise the walking distance the order in which he needs to consume cupcakes
    printf("The order in which he needs to consume cupcakes so as to minimise the walking distance: ");
    for(int i = n-1; i >= 0; i--)
    {
        printf(" %d ", arr[i]);
    }
    printf("\n");
    //initialise float to store 2,s power to be raised 
    float p = 0;
    float number_of_miles = 0;
    float total_to_run;
    //iterate the array in reverse order - decreasing way to get highest calorie intake first
    for(int i = n-1; i >= 0; i--)
    {
      number_of_miles = arr[i] * pow(2.0, p);
      p++;
      total_to_run = total_to_run + number_of_miles;
    }
    printf("\nMarc should walk at least %0.f miles.",total_to_run);
}

void main()
{
  int n;
  printf("Please enter the number of cupcakes: ");
  scanf("%d",&n);
  printf("Respective calorie count of each cupcake: \n");
  int arr[n];
  for(int i=0;i<n;i++)
  {
    scanf("%d",&arr[i]);
  }
  miles_count(arr,n);
}