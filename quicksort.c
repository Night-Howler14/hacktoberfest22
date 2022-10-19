#include <stdio.h>
#include <stdlib.h>

int swap;
int comparision;
void traversal(int *A, int t)
{
    for (int i = 0; i < t; i++)
    {
        printf("%d\t", A[i]);
    }
    printf("\n");
}

void insert_sort(int *a, int n, int l)
{
    int j, key, number_of_swap;
    number_of_swap = 0;
    for (int i = l; i < n - 1; i++)
    {
        key = a[i];
        j = i - 1;
        while (j >= 0 && a[j] > key)
        {
            a[j + 1] = a[j];
            j--;
            number_of_swap++;
        }
        a[j + 1] = key;
    }
    int k = (n-l)*(n-l-1)/2;
    printf("The number of swap taken place in this sorting is %d\n", number_of_swap);
    printf("Total number of comparision is %d\n",k);
}

int modinsert_sort(int A[], int high, int low)
{
    int j, key;
    for (int i = low; i < high - 1; i++)
    {
        key = A[i];
        j = i - 1;
        while (j >= 0 && A[j] > key)
        {
            A[j + 1] = A[j];
            swap++;
            j--;
        }
        A[j + 1] = key;
    }

    return j;
}

int partition(int A[], int low, int high)
{
    int piviot = A[low];
    int i = low + 1;
    int j = high;
    int temp;
    do
    {
        while (A[i] <= piviot)
        {
            i++;
            comparision++;
        }
        while (A[j] > piviot)
        {
            j--;
            comparision++;
        }
        if (i < j)
        {
            temp = A[i];
            A[i] = A[j];
            A[j] = temp;
            swap++;
        }
    } while (j > i);

    if(A[low]!=A[j]){
    temp = A[low];
    A[low] = A[j];
    A[j] = temp;
    swap++;}

    return j;
}
int modpartition(int A[], int low, int high)
{
    int piviot = A[low];
    if (high - low > 50)
    {
        int i = low + 1;
        int j = high;
        int temp;
        do
        {
            while (A[i] <= piviot)
            {
                i++;
                comparision++;
            }
            while (A[j] > piviot)
            {
                j--;
                comparision++;
            }
            if (i < j)
            {
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                swap++;
            }
        } while (j > i);
        if(A[low]!=A[j]){
        temp = A[low];
        A[low] = A[j];
        A[j] = temp;
        swap++;}

        return j;
    }
    else
    {

        modinsert_sort(A, high, low);
        int f = high - low;
        comparision = comparision + (f * (f - 1) / 2);
        for (int i = low; i < high; i++)
        {
            if (A[i] == piviot)
            {
                return i;
            }
        }
    }
}

void quicksort(int A[], int low, int high)
{
    int partitionindex;
    if (low < high)
    {
        partitionindex = partition(A, low, high);
        quicksort(A, low, partitionindex - 1);
        quicksort(A, partitionindex + 1, high);
    }
}
void modquicksort(int A[], int low, int high)
{
    int partitionindex;
    if (low < high)
    {
        partitionindex = modpartition(A, low, high);
        modquicksort(A, low, partitionindex - 1);
        modquicksort(A, partitionindex + 1, high);
    }
}

int copy_array(int A[], int B[], int n, int x)
{
    int count = n;
    int temp;
    for (int i = 0; i < n; i++)
    {
        temp = A[i];
        B[i] = A[i];
        A[i] = temp;
    }
    for (int i = 1000; i < 1010; i++)
    {
        B[i] = rand() % x;
        count++;
    }
    return count;

    

}

int main()
{

    int A[2000], B[2000],C[2000],D[2000];
    int upperlimit;
    printf("Enter the upper limit\n");
    scanf("%d", &upperlimit);
    int count = 0;
    int count1;
    // For generating 1000 random numbers
    for (int i = 0; i < 1000; i++)
    {
        A[i] = rand() % upperlimit;
        count++;
    }

    // menu
    while (1)
    {
        int t;
        printf("Enter 1 for quick_sort\n");
        printf("Enter 2 for insertion_sort\n");
        printf("Enter 3 for printing A\n");
        printf("Enter 4 for printfing B\n");
        printf("Enter 5 for quick_sort on B\n");
        printf("Enter 6 for insertion_sort on B\n");
        printf("Enter 7 for modified quicksort on A\n");
        printf("Enter 8 for modified quicksort on B\n");
        scanf("%d", &t);
        switch (t)
        {
        case 1:
            swap = 0;
            comparision = 0;
            quicksort(A, 0, count - 1);
            printf("Total number of swap is %d\n", swap);
            printf("Total number of comparision is %d\n", comparision);
            count1 = copy_array(A, B,count, upperlimit);
            break;
        case 2:
            insert_sort(A, count, 0);
            count1 = copy_array(A, B,count, upperlimit);
            break;
        case 3:
            traversal(A, count);
            break;
        case 4:
            traversal(B, count1);
            break;
        case 5:
            swap = 0;
            comparision = 0;
            quicksort(B, 0, count1 - 1);
            printf("Total number of swap is %d\n", swap);
            printf("Total number of comparision is %d\n", comparision);
            break;
        case 6:
            insert_sort(B, count1, 0);
            break;
        case 7:
            swap = 0;
            comparision = 0;
            modquicksort(A, 0, count - 1);
            printf("Total number of swaps is %d\n", swap);
            printf("Total comparosions are %d\n", comparision);
            break;
        case 8:
            swap = 0;
            comparision = 0;
            modquicksort(B, 0, count1 - 1);
            printf("Total number of swaps id %d\n", swap);
            printf("Total comparision are %d\n", comparision);
            break;
        default:
            break;
        }
    }

    return 0;
}