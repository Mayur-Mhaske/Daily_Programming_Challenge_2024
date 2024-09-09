
public class SortArray {
    public static void sortArray(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        // Traverse the array
        while (mid <= high) {
            switch (arr[mid]) {
                case 0: // If the element is 0
                    // Swap arr[low] and arr[mid]
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                
                case 1: // If the element is 1
                    mid++;
                    break;
                
                case 2: // If the element is 2
                    // Swap arr[mid] and arr[high]
                    temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 0, 2, 1, 0};
        sortArray(arr);
        
        // Print sorted array
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
