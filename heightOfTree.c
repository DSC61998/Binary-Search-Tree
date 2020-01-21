#include<stdio.h>

typedef struct treeNode
{
	int data;
	struct treeNode *right;
	struct treeNode *left;
}treeNode;

treeNode *root = NULL;
treeNode *temp = NULL;

void search(treeNode *root)
{
	if(root->data < temp->data &&  root->right != NULL)
		search(root->right);
	if(root->data < temp->data && root-> right == NULL)
		root->right = temp;
	if(root->data > temp->data && root->left != NULL)
		search(root->left);
	if(root->data > temp->data && root->left == NULL)
		root->left = temp;
}

void create(n)
{
	int num;
	int i;
	for(i = 0; i < n; i++)
	{
		printf("Enter a number : ");
		scanf("%d", &num);
		temp = (treeNode*)malloc(sizeof(treeNode));
		
		temp->data = num;
		temp->right = NULL;
		temp->left = NULL;
		
		if(root == NULL)
		{
			root =  temp;
		}
		
		else
		{
			search(root);
		}
	}
}

void traverse(treeNode *root)
{
	if(root == NULL)
		printf("Tree is empty");
	printf("%d \n", root->data);
	if(root->left != NULL)
		traverse(root->left);
	if(root->right != NULL)
		traverse(root->right);
}

int max(int a, int b)
{
	return a > b? a: b;
}

int height(treeNode* node)  
{  
    if (node == NULL)  
        return 0;  
    else
    {  
        /* compute the depth of each subtree */
        int lDepth = height(node->left);  
        int rDepth = height(node->right);  
      
        /* use the larger one */
        if (lDepth > rDepth)  
            return(lDepth + 1);  
        else return(rDepth + 1);  
    }  
} 

int main()
{
	int n;
	printf("Enter the number of nodes u ");
	scanf("%d", &n);
	create(n);
	traverse(root);
	printf("Height of the given tree is : %d ", height(root));
}
