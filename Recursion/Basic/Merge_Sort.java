public class Merge_Sort {
    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temporary arrays to store the two halves
        int L[] = new int[n1];
        int R[] = new int[n2];
        int k = l;
        
        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[k++];
        for (int j = 0; j < n2; j++)
            R[j] = arr[k++];

        // Merge the temporary arrays back into arr[l..r]
        int i = 0; // Initial index of first subarray
        int j = 0; // Initial index of second subarray
        k = l; // Initial index of merged subarray

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void mergeSort(int arr[], int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    public static void main(String[] args) {
        int array[] = {5, 4, 3, 2, 1};
        int l = 0;
        int r = array.length - 1;  // Fix: r should be last index, not length

        Merge_Sort sorter = new Merge_Sort();  // Fix: Create an instance
        sorter.mergeSort(array, l, r);

        // Print sorted array
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
