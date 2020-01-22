import java.util.*;
import java.util.Stack;
class DNode
{
    int data;
    DNode next;
    DNode prev;

    DNode(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

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

public class BstToDoubly2
{
    //root node of the tree
    Node root;
    DNode droot;

    //function for searching the proper position for inserting a node into a tree
    public void search(Node temp, Node newNode)
    {
        //traversig left side of a tree
        if(temp.data > newNode.data && temp.left != null)
            search(temp.left, newNode);
        if(temp.data > newNode.data && temp.left == null)
            temp.left = newNode;

        //traversign right side of a tree
        if(temp.data < newNode.data && temp.right != null)
            search(temp.right, newNode);
        if(temp.data < newNode.data && temp.right == null)
            temp.right = newNode;
    }

    //function for creating node for a tree and inserting in a tree
    public void createNode(int num)
    {
        Node newNode = new Node(num);
        if(root == null)
            root = newNode;
        else
        {
            Node temp = root;
            search(temp, newNode);
        }
    }


    //creating Doubly linked List based  on the concept of Breadth First Search
    void createDoubly(int value)
    {
        DNode temp = new DNode(value);
        if(droot == null)                       //First node of doubly linked list
            droot = temp;
        else
        {
            DNode temp2 = droot;               //Traversing through the doubly linked for appropriate location
            while(temp2.next != null)
                temp2 = temp2.next;
            temp2.next = temp;
            temp.prev = temp2;
        }
    }

    void traverseDoubly(DNode temp)
    {
        if(temp == null)
            System.out.println("Can not display doubly linked list : ");
        else
        {
            while(temp != null)
            {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    //traversing tree in inorder manner 
    public void traverse(Node t)
    {
        if(t == null)
        System.out.println("Tree is empty : ");                                 

        else
        {
            Stack<Node> stack = new Stack<Node>();
            while(true)
            {
                while(t != null)
                {
                    stack.push(t);
                    createDoubly(t.data);
                    t = t.left;
                }
                if(stack.isEmpty())
                    break;
                t = stack.pop();
                //System.out.println(t.data);
                t = t.right;
            }
        }
    }

    public static void main(String[] args)
    {
        BstToDoubly2 obj = new BstToDoubly2();
        Scanner scan = new Scanner(System.in);
        int n;
        int num;

        System.out.println("Enter the number of nodes in a tree : ");
        n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter a number : ");
            num = scan.nextInt();
            obj.createNode(num);
        }

        
        obj.traverse(obj.root);
        obj.traverseDoubly(obj.droot);
        scan.close();
    }
}