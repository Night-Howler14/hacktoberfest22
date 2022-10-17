//  bubble_sort.cpp: Rishabh Dev
//  Description: First implementation of bubble sort.
#include <iostream>
using namespace std;

void swap(int *num1, int *num2)
{
    int temp = *num1;
    *num1 = *num2;
    *num2 = temp;
}

void bubble_sort(int arr[], int size)
{
    for (int i = 0; i < size; i++)
    {
        for (int j = i; j < size; j++)
        {
            if (arr[j] < arr[i])
            {
                swap(&arr[j], &arr[i]);
            }
        }
    }
}

int main()
{
    int arr[] = {6, 5, 4, 7, 6, 6, 4, 8, 6, 2, 8, 9, 2, 4, 9};
    int size = sizeof(arr) / sizeof(arr[0]);
    bubble_sort(arr, size);

    for (int i = 0; i < size; i++)
    {
        cout << arr[i] << " ";
    }
    return 0;
}