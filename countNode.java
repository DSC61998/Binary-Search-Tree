
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;


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

public class countNode
{
    //root node of the tree
    Node root;

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

    //traversing a tree in a pre-order manner
    public void traverse(Node temp)
    {
        if(temp == null)
            System.out.println("Tree is empty : ");
        else
        {
            System.out.println(temp.data +  " ");
            if(temp.left != null)
                traverse(temp.left);
            if(temp.right != null)
                traverse(temp.right);
        }
    }

    public int count(Node temp)
    {   
        int count = 0;
        if(temp == null)
            return 0;
        else
        {
            Queue<Node> queue = new LinkedList<Node>();
            while(true)
            {
                while(temp != null)
                {
                    queue.add(temp);
                    temp = temp.left;
                }

                if(queue.isEmpty())
                    break;
                
                temp = queue.poll();
                count++;
                if(temp.right != null);
                    temp = temp.right;
            }
        }
        return count;
    }
 

    public static void main(String[] args)
    {
        countNode obj = new countNode();
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

        System.out.println("Number of nodes in a tree : " + obj.count(obj.root));
        scan.close();
    }
}