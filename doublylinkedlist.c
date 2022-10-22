#include <stdio.h>
#include<stdlib.h>
struct node{
    int data;
    struct node*prev;
    struct node*next;
};
void traverseForward(struct node*ptr){
    while(ptr!=NULL){
        printf("%d ",ptr->data);
        ptr=ptr->next;
    }
}
void traverseBackward(struct node*ptr){
    struct node*q=ptr;
    while(ptr->next!=NULL){
        ptr=ptr->next;
    }
    while(ptr->prev!=q){
        printf("%d ",ptr->data);
        ptr=ptr->prev;
    }
}
struct node*insertAtFront(struct node*n1,int data){
    struct node*ptr=(struct node*)malloc(sizeof(struct node));
    ptr->data=data;
    ptr->next=n1;
    ptr->prev=NULL;
    n1->prev=ptr;
    n1=ptr;
    return n1;
}
struct node*insertAtEnd(struct node*n1,int data){
    struct node*ptr=(struct node*)malloc(sizeof(struct node));
    ptr->prev=NULL;
    ptr->next=NULL;
    ptr->data=data;
    struct node*p=n1;
    while(p->next!=NULL){
        p=p->next;
    }
    p->next=ptr;
    ptr->prev=p;
    return n1;
}
struct node*insertAtIndex(struct node*n1,int data,int index){
    struct node*ptr=(struct node*)malloc(sizeof(struct node));
    ptr->data=data;
    ptr->next=NULL;
    ptr->prev=NULL;
    struct node*p=n1;
    struct node*q=p->next;
    for(int i=0;i<index-1;i++){
        p=p->next;
        q=q->next;
    }
    p->next=ptr;
    ptr->prev=p;
    ptr->next=q;
    q->prev=ptr;
    return n1;
}
struct node*deleteFirstNode(struct node*n1){
    struct node*p=n1;
    n1=n1->next;
    free(p);
    n1->prev=NULL;
    p=NULL;
    return n1;
}
struct node*deleteLastNode(struct node*n1){
    struct node*p=n1;
    struct node*q=p->next;
    while(q->next!=NULL){
        p=p->next;
        q=q->next;
    }
    p->next=NULL;
    free(q);
    q=NULL;
    return n1;
}
struct node*deleteAtIndex(struct node*n1,int index){
    struct node*p=n1;
    struct node*q=p->next;
    for(int i=0;i<index-1;i++){
        p=p->next;
        q=q->next;
    }
    p->next=q->next;
    q->next->prev=p;
    free(q);
    q=NULL;
    return n1;
}
int main(){
    struct node*n1=(struct node*)malloc(sizeof(struct node));
    struct node*n2=(struct node*)malloc(sizeof(struct node));
    struct node*n3=(struct node*)malloc(sizeof(struct node));
    struct node*n4=(struct node*)malloc(sizeof(struct node));
    n1->data=45;
    n1->prev=NULL;
    n1->next=n2;
    n2->data=56;
    n2->prev=n1;
    n2->next=n3;
    n3->data=64;
    n3->prev=n2;
    n3->next=n4;
    n4->data=79;
    n4->prev=n3;
    n4->next=NULL;
    printf("\nlinked list from forward direction is: \n");
    //n1=insertAtFront(n1,80);
    //n1=insertAtEnd(n1,37);
    //n1=insertAtIndex(n1,55,2);
    //n1=deleteFirstNode(n1);
    //n1=deleteLastNode(n1);
    //n1=deleteAtIndex(n1,2);
    traverseBackward(n1);
    /*printf("\nlinked list from backward direction is: \n");
    traverseBackward(n4);*/
    return 0;
}