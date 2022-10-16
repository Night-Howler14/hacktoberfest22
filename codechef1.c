#include <stdio.h>
#include <stdlib.h>

struct node {
  int item;
  struct node* left;
  struct node* right;
};

// Inorder traversal
void inordertraversal(struct node* root) {
  if (root == NULL) return;
  inordertraversal(root->left);
  printf("%d ->", root->item);
  inordertraversal(root->right);
}

// preorderTraversal traversal
void preordertraversal(struct node* root) {
  if (root == NULL) return;
  printf("%d ->", root->item);
  preordertraversal(root->left);
  preordertraversal(root->right);
}

// postorderTraversal traversal
void postordertraversal(struct node* root) {
  if (root == NULL) return;
  postordertraversal(root->left);
  postordertraversal(root->right);
  printf("%d ->", root->item);
}

// Create a new Node
struct node* createnode(int value) {
  struct node* newNode = malloc(sizeof(struct node));
  newNode->item = value;
  newNode->left = NULL;
  newNode->right = NULL;

  return newNode;
}

// Insert on the left of the node
struct node* insertleft(struct node* root, int value) {
  root->left = createnode(value);
  return root->left;
}

// Insert on the right of the node
struct node* insertright(struct node* root, int value) {
  root->right = createnode(value);
  return root->right;
}

int main() {
    int t;
    scanf("%d",&t);
  struct node* root = createnode(t);
    int i;
    printf("give 1 for insertright\n");
    printf("give 2 for insertleft\n");
    printf("give 3 for postordertraversal\n");
    printf("give 4 for preordertraversal\n");
    printf("give 5 for inordertraversal\n");
    scanf("%d",&i);
    if(i==1){
        int s;
        printf("give value\n");
        scanf("%d",&s);
        insertright(root,s);
    }
    if(i==2){
        int s;
        printf("give value\n");
        scanf("%d",&s);
        insertleft(root,s);
    }
    if(i==3){
        printf("postorder traversal\n");
        postordertraversal(root);
    }
    if(i==4){
        printf("preordertraversal\n");
        preordertraversal(root);
    }
    if(i==5){
        printf("inorder traversal\n");
        inordertraversal(root);
    }
//   insertLeft(root, 12);
//   insertRight(root, 9);

//   insertLeft(root->left, 5);
//   insertRight(root->left, 6);

//   printf("Inorder traversal \n");
//   inorderTraversal(root);

//   printf("\nPreorder traversal \n");
//   preorderTraversal(root);

//   printf("\nPostorder traversal \n");
//   postorderTraversal(root);
}