import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class two_sum_day6 {
public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // HashMap to store the prefix sum and the list of indices where the sum occurred
        HashMap<Integer, List<Integer>> prefixSumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int prefixSum = 0;

        // Initialize prefixSumMap with prefix sum 0 at index -1
        prefixSumMap.put(0, new ArrayList<>());
        prefixSumMap.get(0).add(-1);

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If the prefix sum is found in the map, it means there's a zero-sum subarray
            if (prefixSumMap.containsKey(prefixSum)) {
                for (int startIdx : prefixSumMap.get(prefixSum)) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            // Add the current index to the list of the prefix sum in the map
            prefixSumMap.putIfAbsent(prefixSum, new ArrayList<>());
            prefixSumMap.get(prefixSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 3, -1, 2};

        List<int[]> result = findZeroSumSubarrays(arr);

        // Print all the subarrays found
        for (int[] subarray : result) {
            System.out.println("(" + subarray[0] + ", " + subarray[1] + ")");
        }
    }
}
    

