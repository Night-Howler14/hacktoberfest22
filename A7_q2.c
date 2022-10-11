#include <stdio.h>
#include <stdlib.h>
struct Node *head = NULL;
struct Node
{
    int data;
    struct Node *next;
};
void insert(int data)
{
    struct Node *p = (struct Node *)malloc(sizeof(struct Node));
    p->data = data;
    if (head == NULL)
    {
        head = p;
        p->next = NULL;
    }
    else
    {
        p->next = head;
        head = p;
    }
}
int pop()
{
    struct Node *p = head;
    return p->data;
    head = p->next;
    free(p);
}
void print()
{
    struct Node *p = head;
    printf("\nData in the list:\n");
    while (p != NULL)
    {
        printf("%d ", p->data);
        p = p->next;
    }
}
int main()
{
    int n;
    printf("Enter the number of pertrol Pump:=");
    scanf("%d", &n);
    int arr[n];
    int c;
    printf("Enter the fuel capacity of car:=");
    scanf("%d", &c);
    for (int i = 0; i < n; i++)
    {
        printf("Enter the relative distance of pertrol Pump[%d]:=", i + 1);
        scanf("%d", &arr[i]);
    }
    int totaltravel = c;
    int count = 0;
    int arr2[100];
    int y = 0;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] >= totaltravel)
        {
            if (arr[i] > totaltravel)
            {
                insert(arr[--i]);
                arr2[y] = i+1;
                y++;
            }
            else
            {
                insert(arr[i]);
                arr2[y] = i + 1;
                y++;
            }
            int dist = pop();

            totaltravel = totaltravel + (totaltravel - dist) + c;
            count++;
        }
    }
    printf("\nThe number of stops:=%d", count);
    printf("\npetrol pump at which it's making stops\n");
    for (int i = 0; i < y; i++)
    {
        printf("%d ", arr2[i]);
    }
}