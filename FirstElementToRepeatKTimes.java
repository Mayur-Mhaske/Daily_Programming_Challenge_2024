import java.util.HashMap;

public class FirstElementToRepeatKTimes {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        int k = 2;
        int result = findFirstElement(arr, k);
        System.out.println(result);  // Output: 1
    }

    public static int findFirstElement(int[] arr, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the first element that appears exactly k times
        for (int num : arr) {
            if (frequencyMap.get(num) == k) {
                return num;
            }
        }

        // If no element found, return -1
        return -1;
    }
}
