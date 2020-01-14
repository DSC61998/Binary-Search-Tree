#include<stdio.h>

typedef struct treeNode
{
	int data;
	struct treeNode *right;
	struct treeNode *left;
}treeNode;

treeNode *temp = NULL;

int similar(treeNode *root1, treeNode *root2)
{
	if(root1 == NULL && root2 == NULL)
		return 1;
	if(root1 != NULL && root2 != NULL)
	{
		if(root1->data == root2->data && similar(root1->left, root2->left) && similar(root1->right, root2->right))
		{
			return 1;
		}
	}
	return 0;	
}

void search(treeNode *root)
{
	if(root->data > temp->data && root->left != NULL)
		search(root->left);
	if(root->data > temp->data && root->left == NULL)
		root->left = temp;
	if(root->data < temp->data && root->right != NULL)
		search(root->right);
	if(root->data < temp->data && root->right == NULL)
		root->right = temp;
}


treeNode *create(treeNode *root, int num)
{
	int i;
	int a;
	for(i = 1; i <= num; i++)
	{
		temp = (treeNode*)malloc(sizeof(treeNode));
		
		printf("Enter a number :");
		scanf("%d", &a);
		
		temp->data = a;
		temp->right = NULL;
		temp->left = NULL;
		
		if(root == NULL)
			root = temp;
		else
			search(root);
	}
	return root;
}

void inorder(treeNode *root)
{
	if(root == NULL)
		printf("The tree is empty ");
	printf("%d ", root->data);
	if(root->left != NULL)
	{
		inorder(root->left);
	}
	if(root->right != NULL)
	{
		inorder(root->right);
	}
}


int main()
{
	int num;
	
	treeNode *root1 = NULL;
	printf("Enter the number of nodes  in tree 1 ");
	scanf("%d", &num);
	root1 = create(root1, num);
	
	printf("\n");
	
	treeNode *root2 = NULL;
	printf("Enter the number of nodes  in tree 2 ");
	scanf("%d", &num);
	root2 = create(root2, num);
	
	printf("Tree 1 nodes ");
	inorder(root1);
	printf("\n");
	
	printf("Tree 2 nodes ");
	inorder(root2);
	printf("\n");
	
	if(similar(root1, root2))
	{
		printf("Tree is similar ");
	}
	else 
	{
		printf("Tree is not similar ");
	}
	
	
	
	
}
