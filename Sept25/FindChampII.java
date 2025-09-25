package Sept25;

import java.util.Arrays;

public class FindChampII {
    public static int findChampII(int n, int[][] edges) {
        boolean[] isUndefeated = new boolean[n];
        Arrays.fill(isUndefeated, true);
        for (int[] edge : edges) {
            int loser = edge[1];
            isUndefeated[loser] = false;
        }

        int champ = -1;
        int champCount = 0;
        for (int team = 0; team < n; team++) {
            if (isUndefeated[team]) {
                champ = team;
                champCount++;
            }
        }
        return champCount == 1 ? champ : -1;
    }
}
