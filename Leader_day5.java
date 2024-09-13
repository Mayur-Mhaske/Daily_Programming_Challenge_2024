
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leader_day5 {
    public static List<Integer> findLeaders(int[] arr) {
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        
        if (n == 0) {
            return leaders; 
        }
        
       int maxFromRight = arr[n - 1];
         leaders.add(maxFromRight);
        
      
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > maxFromRight) {
                maxFromRight = arr[i];
                leaders.add(maxFromRight);
            }
        }
        
        Collections.reverse(leaders);
        
        return leaders;
    }
};
  
