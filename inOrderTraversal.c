#include<stdio.h>

typedef struct treeNode
{
	int data;
	struct treeNode *right;
	struct treeNode *left;
}treeNode;

treeNode *root = NULL;
treeNode *temp = NULL;

void search(treeNode *t)
{
	if(t->data > temp->data && t->left != NULL)
		search(t->left);
	if(t->data > temp->data && t->left == NULL)
		t->left = temp;
	if(t->data < temp->data && t->right != NULL)
		search(t->right);
	if(t->data < temp-> data && t->right == NULL)
		t->right = temp;
}


void create(int n)
{
	int i;
	for(i = 1; i <= n; i++)
	{
		temp = (treeNode*)malloc(sizeof(treeNode));
		printf("Enter a number : ");
		scanf("%d", &temp->data);
		temp->right = NULL;
		temp->left = NULL;
		if(root == NULL)
			root = temp;
		else
			search(root);
	}
}

void inOrderTraverse(treeNode *t)
{
	if(root == NULL)
	{
		printf("Tree is empty : ");
	}
	
    if (t->left != NULL)    
        inOrderTraverse(t->left);
    printf("%d ", t->data);
    if (t->right != NULL)    
        inOrderTraverse(t->right);
}

int main()
{
	int num;
	printf("Enter the number of nodes u want to create : ");
	scanf("%d", &num);
	create(num);
	inOrderTraverse(root);
	
	return 0;
}
