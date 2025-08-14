// Binary Search Tree with Inorder, Preorder, and Postorder traversal
import java.util.Scanner;

class Node 
{
    int data;
    Node left, right;

    public Node(int value)
    {
        data = value;
        left = right = null;
    }
}

class BST 
{
    Node root;

    // Insert a node into the BST
    public void insert(int value)
    {
        root = insertRec(root, value);
    }

    // Recursive insert function
    private Node insertRec(Node root, int value) 
        {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) 
        {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }

    // Inorder traversal (Left, Root, Right)
    public void inorder()
        {
        System.out.print("Inorder traversal: ");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) 
        {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }

    // Preorder traversal (Root, Left, Right)
    public void preorder()
    {
        System.out.print("Preorder traversal: ");
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) 
    {
        if (root != null) 
        {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Postorder traversal (Left, Right, Root)
    public void postorder() 
       {
        System.out.print("Postorder traversal: ");
        postorderRec(root);
        System.out.println();
       }

    private void postorderRec(Node root)
    {
        if (root != null) 
        {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
}

public class BinarySearchTreeDemo 
{
    public static void main(String[] args) 
    {
        BST tree = new BST();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of nodes to insert:");
        int n = scanner.nextInt();

        System.out.println("Enter " + n + " integers to insert into BST:");
        for (int i = 0; i < n; i++) 
        {
            int value = scanner.nextInt();
            tree.insert(value);
        }

        System.out.println("\n--- Tree Traversals ---");
        tree.inorder();
        tree.preorder();
        tree.postorder();

        scanner.close();
    }
}
