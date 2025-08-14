import java.util.Scanner;

public class MergeSort 
{

    // Merge two subarrays of arr[]
    public static void merge(int[] arr, int left, int mid, int right) 
    {
        // Sizes of two subarrays to merge
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        // Merge the temp arrays

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2)
         {
            if (L[i] <= R[j]) 
            {
                arr[k] = L[i];
                i++;
            } else 
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) 
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) 
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Recursive function that sorts arr[left...right] using merge()
    public static void mergeSort(int[] arr, int left, int right)
    {
        if (left < right) 
        {
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Function to print the array
    public static void printArray(int[] arr) 
    {
        for (int val : arr)
            System.out.print(val + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        System.out.println("\nOriginal array:");
        printArray(arr);

        // Perform Merge Sort
        mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        printArray(arr);

        scanner.close();
    }
}
