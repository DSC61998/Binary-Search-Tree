#include<stdio.h>

typedef struct treeNode
{
	int data;
	struct treeNode *right;
	struct treeNode *left;
}treeNode;

treeNode *root = NULL;
treeNode *temp = NULL;

int size(treeNode *t)
{
	if(t == NULL)
		return 0;
	if( t!= NULL)
	{
		int leftSize = size(t->left);
		int rightSize = size(t->right);
		return leftSize + rightSize + 1;
	}
}

void search(treeNode *t)
{
	if(t->data > temp->data && t->left != NULL)
		search(t->left);
	if(t->data > temp->data && t->left == NULL)
		t->left = temp;
	if(t->data < temp->data && t->right != NULL)
		search(t->right);
	if(t->data < temp->data && t->right == NULL)
		t->right = temp;
}


void create(int n)
{
	int a;
	int i;
	
	for(i = 1; i <= n; i++)
	{
		temp = (treeNode*)malloc(sizeof(treeNode));
		printf("Enter a number : ");
		scanf("%d", &a);
		
		temp->data = a;
		temp->right = NULL;
		temp->left = NULL;
		
		if(root == NULL)
			root = temp;
		else 
			search(root);
	}
}

void traverse(treeNode *t)
{
	if(t == NULL)
		printf("Tree is empty ");
	printf("%d ", t->data);
	if(t->left != NULL)
		traverse(t->left);
	if(t->right != NULL)
		traverse(t->right);
}

int main()
{
	int num;
	printf("Enter the number of nodes ");
	scanf("%d", &num);
	create(num);
	traverse(root);
	printf("\n");
	printf("Size of the tree is %d ", size(root));
	return 0;
}
