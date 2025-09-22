import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PracticeJava {
    public static void main(String[] args) {
        Map<Integer, Integer> maps = new HashMap<>();
        int[] arr = { 1, 2, 2, 1, 3 };
        for (int n : arr) {
            maps.put(n, maps.getOrDefault(n, 0) + 1);
        }
        System.out.println(maps);
        int maxVal = 0;
        for (int freq : maps.values()) {
            if (freq > maxVal) {
                maxVal = freq;
            }
        }
        List<Integer> res = new ArrayList<>();
        System.out.println(maxVal);
        for (Map.Entry<Integer, Integer> entry : maps.entrySet()) {
            if (entry.getValue() == maxVal) {
                res.add(entry.getKey());
            }
        }
        System.out.println(res);
        int result = res.size() * maxVal;
        System.out.println(result);

    }
}
