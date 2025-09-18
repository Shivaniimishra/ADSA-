import java.util.*;

public class OptimalStorageModified {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take number of programs
        System.out.print("Enter number of programs: ");
        int n = sc.nextInt();

        int[] lengths = new int[n];
        System.out.println("Enter lengths of programs:");
        for (int i = 0; i < n; i++) {
            lengths[i] = sc.nextInt();
        }

        // Sort program lengths
        Arrays.sort(lengths);

        int totalRetrievalTime = 0;
        int cumulativeTime = 0;

        // Calculate total retrieval time
        for (int i = 0; i < n; i++) {
            cumulativeTime += lengths[i];
            totalRetrievalTime += cumulativeTime;
        }

        // Calculate MRT
        double mrt = (double) totalRetrievalTime / n;

        // Print detailed output
        System.out.println("\nSorted Program Lengths: " + Arrays.toString(lengths));
        System.out.println("Total Retrieval Time = " + totalRetrievalTime);
        System.out.println("Mean Retrieval Time (MRT) = " + mrt);

        sc.close();
    }
}
