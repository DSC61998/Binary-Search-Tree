import java.util.Scanner;
import java.util.Stack;


class Node
{
    int data;
    Node right;
    Node left;
    Node(int data)
    {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}
public class itrPreOrderTrav
{
    Node root;
    Node temp;


    //function for searching appropriate position for new Node
    void searchPos(Node t)
    {
        if(t.data > temp.data && t.left != null)
            searchPos(t.left);
        if(t.data > temp.data && t.left == null)
            t.left = temp;
        if(t.data < temp.data && t.right != null)
            searchPos(t.right);
        if(t.data < temp.data && t.right == null)
            t.right = temp;
    }
    //function for creating node and adding them in a tree
    void addNewNode(int num)
    {
        temp = new Node(num);
        if(root == null)
            root = temp;
        else
        {
            searchPos(root);
        }

    }

    void preOrderTraversal(Node t)
    {
        if(t == null)
            System.out.println("Tree is empty : ");                                 
 
        else
        {
            //We will be using stack data structure for implementing 
            //iterative inorder traversal in a tree
            Stack<Node> stack = new Stack<Node>();
            while(true)
            {
                while(t != null)
                {
                    //traverse left side of the tree and push it into the stack 
                    //until u reach null
                    System.out.println(t.data);
                    stack.push(t);
                    t = t.left;
                }

                //breaking condition which tell us that we have travrse all the node of a tree
                if(stack.isEmpty())
                    break;

                //pop out the element from top of the stack 
                //print the  element
                //traverse the right side of the tree
                t = stack.pop();
                t = t.right;
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        itrPreOrderTrav obj = new itrPreOrderTrav();

        int n;
        int num;
        System.out.println("Enter the number of node in a tree : ");
        n = scan.nextInt();

        //inputing numbers for a tree
        for(int i = 1; i<= n; i++)
        {
            System.out.println("Enter a number : ");
            num = scan.nextInt();
            obj.addNewNode(num);
        }

        obj.preOrderTraversal(obj.root);

        scan.close();
    }
}