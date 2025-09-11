package Sept10;

import java.util.HashSet;
import java.util.Set;
// import java.util.Math;

public class MinNumToTeach {
    public int minimumTeachings( int n,int[][] languages, int[][] friends) {
        Set<Integer> need = new HashSet<>();
        int ans = languages.length + 1;
        for (int[] p : friends) {
            int u = p[0] - 1, v = p[1] - 1; // convert to 0 based
            boolean canSpeak = false;
            for (int x : languages[u]) {
                for (int y : languages[v]) {
                    if (x == y) {
                        canSpeak = true;
                        break;
                    }
                }
                if (canSpeak)
                    break;
            }
            if (!canSpeak) {
                need.add(u);
                need.add(v);
            }
        }
        for (int i = 1; i <= n; i++) {
            int canTaught = 0;
            for (int v : need) {
                boolean found = false;
                for (int c : languages[v]) {
                    if (c == i) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    canTaught++;
                }
            }
            ans = Math.min(ans, canTaught);
        }
        return ans;
    }
}
