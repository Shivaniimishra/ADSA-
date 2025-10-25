import java.util.Scanner;

public class HamiltonianCycle 
{

    // Check if vertex v can be added at position pos
    static boolean isSafe(int v, int graph[][], int path[], int pos) 
    {
        // Check if vertex is adjacent to the previous vertex
        if (graph[path[pos - 1]][v] == 0) return false;

        // Check if vertex is already included in the path
        for (int i = 0; i < pos; i++) 
        {
            if (path[i] == v) return false;
        }

        return true;
    }

    // Recursive utility function
    static boolean hamCycleUtil(int graph[][], int path[], int pos) 
    {
        int V = graph.length;
        if (pos == V) 
        {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < V; v++) 
        {
            if (isSafe(v, graph, path, pos)) 
            {
                path[pos] = v;
                if (hamCycleUtil(graph, path, pos + 1)) return true;
                path[pos] = -1; // Backtracking
            }
        }

        return false;
    }

    // Main function to solve Hamiltonian Cycle
    static void hamCycle(int graph[][]) 
    {
        int V = graph.length;
        int[] path = new int[V];
        for (int i = 0; i < V; i++) path[i] = -1;

        path[0] = 0; // Start at vertex 0

        if (!hamCycleUtil(graph, path, 1)) 
        {
            System.out.println("No Hamiltonian Cycle exists");
            return;
        }

        System.out.println("Hamiltonian Cycle exists:");
        for (int i = 0; i < V; i++) 
        {
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]); // To show cycle back to start
    }

    // User input
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        int[][] graph = new int[V][V];

        System.out.println("Enter adjacency matrix:");
        for (int i = 0; i < V; i++) 
        {
            for (int j = 0; j < V; j++) 
            {
                graph[i][j] = sc.nextInt();
            }
        }

        hamCycle(graph);
        sc.close();
    }
}

