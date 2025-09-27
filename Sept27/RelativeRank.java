import java.util.PriorityQueue;

public class RelativeRank {

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Pair<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> b.getKey() - a.getKey());
        for (int i = 0; i < n; i++) {
            heap.add(new Pair<>(score[i], i));
        }
        String[] rank = new String[n];
        int place = 1;
        while (!heap.isEmpty()) {
            Pair<Integer, Integer> pair = heap.poll();
            int originalIdx = pair.getValue();
            if (place == 1) {
                rank[originalIdx] = "Gold Medal";
            } else if (place == 2) {
                rank[originalIdx] = "Silver Medal";
            } else if (place == 3) {
                rank[originalIdx] = "Bronze Medal";
            } else {
                rank[originalIdx] = String.valueOf(place);
            }
            place++;
        }
        return rank;
    }

}
