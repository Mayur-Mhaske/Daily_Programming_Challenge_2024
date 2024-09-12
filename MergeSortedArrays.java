public class MergeSortedArrays {
    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1; // Pointer for the last element in the initial part of arr1
        int j = n - 1; // Pointer for the last element in arr2
        int k = m + n - 1; // Pointer for the last position in arr1 (full capacity)

        // Merge arr2 into arr1
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k--] = arr1[i--];
            } else {
                arr1[k--] = arr2[j--];
            }
        }

        // If there are remaining elements in arr2, copy them
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }

        // Optionally, if you want to see the result of arr1 and arr2
        // System.out.println("arr1: " + Arrays.toString(arr1));
        // System.out.println("arr2: " + Arrays.toString(arr2));
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr1 = new int[8]; // Size m + n = 4 + 4
        arr1[0] = 1;
        arr1[1] = 3;
        arr1[2] = 5;
        arr1[3] = 7;
        
        int[] arr2 = {2, 4, 6, 8};
        
        // Fill arr1 with the initial elements and extra space for arr2
        merge(arr1, 4, arr2, 4);

        // Print the result
        System.out.println("arr1: " + java.util.Arrays.toString(arr1));
        System.out.println("arr2: " + java.util.Arrays.toString(arr2)); // arr2 remains unchanged
    }
}
