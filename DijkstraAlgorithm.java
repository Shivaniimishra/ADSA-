import java.util.*;

public class DijkstraAlgorithm 
{
    private static final int INF = Integer.MAX_VALUE;

    public static void dijkstra(int[][] graph, int source) 
    {
        int vertices = graph.length;
        int[] distance = new int[vertices];    // shortest distance from source
        boolean[] visited = new boolean[vertices]; // visited vertices

        // Step 1: Initialize distances
        Arrays.fill(distance, INF);
        distance[source] = 0;

        // Step 2: Process each vertex
        for (int count = 0; count < vertices - 1; count++) 
        {
            int u = selectMinVertex(distance, visited);
            visited[u] = true;

            // Step 3: Update distance of adjacent vertices
            for (int v = 0; v < vertices; v++) 
            {
                if (!visited[v] && graph[u][v] != 0 && distance[u] != INF &&
                        distance[u] + graph[u][v] < distance[v]) 
                {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        // Step 4: Print the shortest distances
        System.out.println("Vertex \t Distance from Source (" + source + ")");
        for (int i = 0; i < vertices; i++) 
        {
            System.out.println(i + "\t\t" + distance[i]);
        }
    }

    // Helper function to select vertex with min distance
    private static int selectMinVertex(int[] distance, boolean[] visited) 
    {
        int min = INF, minIndex = -1;
        for (int i = 0; i < distance.length; i++) 
        {
            if (!visited[i] && distance[i] < min)
            {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int vertices = sc.nextInt();

        int[][] graph = new int[vertices][vertices];
        System.out.println("Enter the adjacency matrix (0 if no edge):");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) 
            {
                graph[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter source vertex: ");
        int source = sc.nextInt();

        dijkstra(graph, source);
    }
}
