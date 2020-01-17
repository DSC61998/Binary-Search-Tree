import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList; 

class Node
{
    int data;
    Node left;
    Node right;

    Node(int item)
    {
        this.data = item;
        this.left = null;
        this.right = null;
    }
}

public class levelOrderTraversal
{
    Node root;

    public void search(Node focusNode, Node newNode)
    {
        //traversing right side of the tree for searching appropriate position
        if(focusNode.data < newNode.data && focusNode.right != null)
            search(focusNode.right, newNode);
        if(focusNode.data < newNode.data && focusNode.right == null)
            focusNode.right = newNode;
        
        //traversing left side of the tree for seraching appropriate position
        if(focusNode.data > newNode.data && focusNode.left != null)
            search(focusNode.left, newNode);
        if(focusNode.data > newNode.data && focusNode.left == null)
            focusNode.left = newNode;
    }

    public void addNode(int data)
    {
        Node newNode = new Node(data);
        if(root == null)
            root = newNode;
        else
        {
            Node focusNode = root;
            search(focusNode, newNode);
        }
    }

    public void traverse(Node focus)
    {
        if(focus == null)
            System.out.println("tree is empty ");
        else
        {
            System.out.println(focus.data);
            if(focus.left != null)
                traverse(focus.left);
            if(focus.right != null)
                traverse(focus.right);
        }
    }

    public void levelOrder(Node focus)
    {
        if(focus == null)
            System.out.println("Tree is empty");
        else
        {
            Queue<Node> que = new LinkedList<Node>();
            que.add(focus);
            while(!que.isEmpty())
            {
                Node temp = que.poll();
                System.out.println(temp.data + " ");
                if(temp.left != null)
                    que.add(temp.left);
                if(temp.right != null)
                    que.add(temp.right);
            }
        }
    }

    public static void  main(String[] args) 
    {

        levelOrderTraversal obj = new levelOrderTraversal();
        int num;
        int n;

        Scanner scan  = new Scanner(System.in);

        System.out.println("Enter the number of nodes in tree : ");
        n = scan.nextInt();

        for(int i = 0; i < n; i++)
        {
            System.out.println("Enter a number u want to enter : ");
            num = scan.nextInt();
            obj.addNode(num);
        }
        scan.close();
        System.out.println("Traversing a tree : ");
        obj.traverse(obj.root);

        System.out.println("Traversing a tree in level order : ");
        obj.levelOrder(obj.root);
    }
}