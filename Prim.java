import java.util.Scanner;

public class Prim{
    static final int INF = 999999; // A large number representing infinity

    public static void primMST(int[][] graph, int n) {
        int[] parent = new int[n];       // Store MST edges
        int[] key = new int[n];          // Smallest edge weight to connect vertex
        boolean[] inMST = new boolean[n]; // Track vertices included in MST

        // Initialize keys as infinite
        for (int i = 0; i < n; i++) {
            key[i] = INF;
            inMST[i] = false;
        }

        key[0] = 0;      // Start from vertex 0
        parent[0] = -1;  // Root node has no parent

        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, inMST, n);
            inMST[u] = true;

            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph, n);
    }

    // Helper to find vertex with minimum key value
    static int minKey(int[] key, boolean[] inMST, int n) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < n; v++) {
            if (!inMST[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Print the MST
    static void printMST(int[] parent, int[][] graph, int n) {
        int totalWeight = 0;
        System.out.println("\nMinimum Spanning Tree Edges:");
        System.out.println("Edge\tWeight");
        for (int i = 1; i < n; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
            totalWeight += graph[i][parent[i]];
        }
        System.out.println("Total weight of MST = " + totalWeight);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number of vertices
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        // Step 2: Input adjacency matrix
        System.out.println("Enter the adjacency matrix (0 for no edge):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        // Step 3: Run Prim's Algorithm
        primMST(graph, n);

        sc.close();
    }
}
