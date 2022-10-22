#include<stdio.h>
#include<stdlib.h>
 
struct Node
{
    int data;
    struct Node *next;
};
 
void linkedListTraversal(struct Node *head){
    struct Node *ptr = head;
    do{
        printf("Element is %d\n", ptr->data);
        ptr = ptr->next;
    }while(ptr!=head);
}
 
struct Node * insertAtFirst(struct Node *head, int data){
    struct Node * ptr = (struct Node *) malloc(sizeof(struct Node));
    ptr->data = data;
 
    struct Node * p = head->next;
    while(p->next != head){
        p = p->next;
    }
    // At this point p points to the last node of this circular linked list
 
    p->next = ptr;
    ptr->next = head;
    head = ptr;
    return head;
 
}

struct Node* insertAtEnd(struct Node*head, int data){
    struct Node * ptr = (struct Node *) malloc(sizeof(struct Node));
    ptr->data = data;
 
    struct Node * p = head->next;
    while(p->next != head){
        p = p->next;
    }
    // At this point p points to the last node of this circular linked list
 
    p->next = ptr;
    ptr->next = head;
    return head;
} 

struct Node* insertInBetween(struct Node* head, int index, int value){
    struct Node*ptr=(struct Node*)malloc(sizeof(struct Node));
    ptr->data=value;
    struct Node*p=head->next;
    struct Node*q=p->next;
    for (int i=0;i<index-1;i++){
        p=p->next;
        q=q->next;
    }
    p->next=ptr;
    ptr->next=q;
    return head;
}

struct Node* deleteAtEnd(struct Node*head){
    struct Node*p=head;
    struct Node*q=head->next;
    while(q->next!=head){
        p=p->next;
        q=q->next;
    }
    p->next=head;
    free(q);
    return head;
}

struct Node* deleteFirstNode(struct Node*head){
    struct Node*q=head->next;
    while(q->next!=head){
        q=q->next;
    }
    head=head->next;
    q->next=head;
    return head; 
}

struct Node* deleteAtIndex(struct Node*head,int index){
    struct Node*p=head;
    struct Node*q=p->next; 
    for(int i=0;i<index-1;i++){
        p=p->next;
        q=q->next;
    }
    p->next=q->next;
    free(q);
    return head;
}

int main(){  
    struct Node *head;
    struct Node *second;
    struct Node *third;
    struct Node *fourth;
 
    // Allocate memory for nodes in the linked list in Heap
    head = (struct Node *)malloc(sizeof(struct Node));
    second = (struct Node *)malloc(sizeof(struct Node));
    third = (struct Node *)malloc(sizeof(struct Node));
    fourth = (struct Node *)malloc(sizeof(struct Node));
 
    // Link first and second nodes
    head->data = 4;
    head->next = second;
 
    // Link second and third nodes
    second->data = 3;
    second->next = third;
 
    // Link third and fourth nodes
    third->data = 6;
    third->next = fourth;
 
    // Terminate the list at the fourth node
    fourth->data = 1;
    fourth->next = head;

    printf("Circular Linked list before insertion\n");
    linkedListTraversal(head);
   /* head = insertAtFirst(head, 54);
    head = insertAtFirst(head, 58);
    head = insertAtFirst(head, 59);
    printf("Circular Linked list after insertion\n");
    linkedListTraversal(head);*/
    //head=insertAtEnd(head,80);
    //head=insertInBetween(head,1,76);
    //head=deleteAtEnd(head);
    //head=deleteFirstNode(head);
    head=deleteAtIndex(head,1);
    //printf("Circular Linked list after insertion\n");
    printf("Circular Linked list after deletion\n");
    linkedListTraversal(head);
 
    return 0;
}