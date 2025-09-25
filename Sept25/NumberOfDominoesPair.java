package Sept25;

import java.util.Map;
import java.util.HashMap;

public class NumberOfDominoesPair {
    Map<Integer, Integer> mp = new HashMap<>();

    public int numEquivDominoPairs(int[][] dominoes) {
        for (int[] pair : dominoes) {
            int a = pair[0];
            int b = pair[1];

            int key;
            if (a < b) {
                key = a * 10 + b;
            } else {
                key = b * 10 + a;
            }

            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        int totalPairs = 0;
        for (int freq : mp.values()) {
            if (freq >= 2) {
                totalPairs += freq * (freq - 1) / 2;
            }
        }
        return totalPairs;
    }
}
