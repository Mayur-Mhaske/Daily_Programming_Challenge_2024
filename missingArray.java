public class missingArray {

    public static int findMissingNumber(int[] arr, int n) {
        
        int totalSum = n * (n + 1) / 2;

         int arrSum = 0;
        for (int num : arr) {
            arrSum += num;
        }

        return totalSum - arrSum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};  // Array with one missing number
        int n = 5;  // Total numbers from 1 to n
        
        System.out.println("Missing Number: " + findMissingNumber(arr, n));
    }
}