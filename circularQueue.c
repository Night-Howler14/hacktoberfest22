#include <stdio.h>
#include<stdlib.h>
struct queue{
    int size;
    int f;
    int r;
    int *arr;
};
void enqueue(struct queue*q,int val){
    if((q->r+1)%q->size==q->f){
        printf("overflow");
    }
    else{
        q->r=(q->r+1)%q->size;
        q->arr[q->r]=val;
        printf("the enqueued element is:%d\n",val);
    }
}
int dequeue(struct queue*q){
    int a=-1;
    if(q->r==q->f){
        printf("empty queue");
    }
    else{
        q->f=(q->f+1)%q->size;
        a=q->arr[q->f];
    }
    return a;
}
int main(){
    struct queue q;
    q.size=4;
    q.f=q.r=-1;
    q.arr=(int*)malloc(q.size*sizeof(int));
    //enqueue
    enqueue(&q,12);
    enqueue(&q,78);
    enqueue(&q,52);
    enqueue(&q,94);
    //dequeue
    /*printf("the dequeued element is %d\n",dequeue(&q));
    printf("the dequeued element is %d\n",dequeue(&q));
    printf("the dequeued element is %d\n",dequeue(&q));
    printf("the dequeued element is %d\n",dequeue(&q));*/
    enqueue(&q,23);
    return 0;
}