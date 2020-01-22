import java.util.*;


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

public class BstToDoubly
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


    //creating Doubly linked List 
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

    //traversing tree in Breadth First Search manner
    public void traverse(Node temp)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(temp);
        while(!queue.isEmpty())
        {
            temp = queue.poll();
            System.out.println(temp.data);
            createDoubly(temp.data);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
    }

    

    public static void main(String[] args)
    {
        BstToDoubly obj = new BstToDoubly();
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