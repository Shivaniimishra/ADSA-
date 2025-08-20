import java.util.Scanner;

// Node class representing a single node in the BST
class Node 
{
    int data;      // Value stored in the node
    Node left;     // Pointer to the left child
    Node right;    // Pointer to the right child

    // Constructor: initializes a node with a given value
    public Node(int value) 
    {
        data = value;
        left = right = null; // Initially no children
    }
}

// Binary Search Tree class
class BST 
{
    Node root; // Root of the tree

    // Insert a value into the BST
    Node insert(Node root, int value) 
    {
        // If tree/subtree is empty, create and return a new node
        if (root == null)
            return new Node(value);

        // If value is smaller, insert into the left subtree
        if (value < root.data)
            root.left = insert(root.left, value);
        // If value is greater, insert into the right subtree
        else if (value > root.data)
            root.right = insert(root.right, value);

        // Return the root node after insertion
        return root;
    }

    // Search for a given key in the BST
    boolean search(Node root, int key) 
    {
        // Base case: reached leaf without finding key
        if (root == null)
            return false;

        // If key matches the current node
        if (key == root.data)
            return true;
        // If key is smaller, search in left subtree
        else if (key < root.data)
            return search(root.left, key);
        // If key is larger, search in right subtree
        else
            return search(root.right, key);
    }

    // Inorder Traversal (Left → Root → Right)
    void inorder(Node root) 
    {
        if (root != null) 
        {
            inorder(root.left);                 // Visit left subtree
            System.out.print(root.data + " ");  // Visit root
            inorder(root.right);                // Visit right subtree
        }
    }

    // Preorder Traversal (Root → Left → Right)
    void preorder(Node root) 
    {
        if (root != null) 
        {
            System.out.print(root.data + " ");  // Visit root
            preorder(root.left);                // Visit left subtree
            preorder(root.right);               // Visit right subtree
        }
    }

    // Postorder Traversal (Left → Right → Root)
    void postorder(Node root) 
    {
        if (root != null) 
        {
            postorder(root.left);                // Visit left subtree
            postorder(root.right);               // Visit right subtree
            System.out.print(root.data + " ");   // Visit root
        }
    }
}

// Main class with user input
public class Search 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        BST tree = new BST(); // Create a BST object

        // Read number of elements to insert
        System.out.print("Enter number of elements to insert: ");
        int n = sc.nextInt();

        // Insert elements into BST
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) 
        {
            int val = sc.nextInt();
            tree.root = tree.insert(tree.root, val);
        }

        // Display tree traversals
        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

        // Search for a specific value
        System.out.print("\n\nEnter a value to search: ");
        int searchVal = sc.nextInt();

        boolean found = tree.search(tree.root, searchVal);
        System.out.println(searchVal + (found ? " is Found" : " is Not Found"));

        sc.close(); // Close scanner to avoid resource leak
    }
}
