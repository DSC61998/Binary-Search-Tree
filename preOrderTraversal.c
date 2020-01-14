#include<stdio.h>

typedef struct treeNode
{
	int data;
	struct treeNode *right;
	struct treeNode *left;
}treeNode;

treeNode *ROOT = NULL;
treeNode *temp = NULL;

void preorder(treeNode *t)
{
    if (ROOT == NULL)
    {
        printf("No elements in a tree to display");
        return;
    }
    if (t->left != NULL)    
        preorder(t->left);
    if (t->right != NULL)    
        preorder(t->right);
    printf("%d -> ", t->data);
}

void searchPosition(treeNode *t)
{
	if((temp->data > t->data) && t->right != NULL)
		searchPosition(t->right);
	if((temp->data > t->data) && t->right == NULL)
		t->right = temp;
	if((temp->data < t->data) && t->left != NULL)
		searchPosition(t->left);
	if((temp->data < t->data) && t->left == NULL)
		t->left = temp;
}

void  create(int n)
{
	int i;
	for(i = 0; i < n; i++)
	{
		temp = (treeNode*)malloc(sizeof(treeNode));
		printf("Enter a number \n");
		scanf("%d", &temp->data);
		temp->right = NULL;
		temp->left = NULL;
		if(ROOT == NULL)
			ROOT = temp;
		else
			searchPosition(ROOT);
	}
}

int main()
{
	int n;
	printf("Enter the number of entries to be made \n");
	scanf("%d", &n);
	create(n);
	printf("Pre Order traversing \n");
	preorder(ROOT);
	printf("\n");
	return 0;
}
