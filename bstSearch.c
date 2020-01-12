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
	else if(t->data > temp->data && t->left == NULL)
		t->left = temp;
	else if(t->data < temp->data && t->right != NULL)
		search(t->right);
	else if(t->data < temp->data && t->right == NULL)
		t->right = temp;
}

void create(int n)
{
	int i;
	for(i = 1; i <= n; i++)
	{
		temp = (treeNode*)malloc(sizeof(treeNode));
		printf("Enter a number ");
		scanf("%d", &temp->data);
		temp->left = NULL;
		temp->right = NULL;
		
		if(root == NULL)
			root = temp;
		else
			search(root);
	}
}

treeNode *searchKey(treeNode *t, int key)
{
	if(t == NULL)
		return NULL;
	if(t->data == key)
		return t;
	else if(t->data > key)
		searchKey(t->left, key);
	else if(t->data < key)
		searchKey(t->right, key);
}

void traverse(treeNode *t)
{
    if (root == NULL)
    {
        printf("No elements in a tree to display");
        return;
    }
    if (t->left != NULL)    
        traverse(t->left);
    printf("%d -> ", t->data);
    if (t->right != NULL)    
        traverse(t->right);
}

int main()
{
	int n;
	printf("Enter a number of nodes u want to create ");
	scanf("%d", &n);
	create(n);
	traverse(root);
	int key;
	printf("Enter the number u want to search ");
	scanf("%d", &key);
	treeNode *found = searchKey(root, key);
	if(found == NULL)
		printf("Value is not present ");
	else
		printf("value is %d ", found->data);
	return 0;
}
