import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class DesignTaskManager {
    private PriorityQueue<int[]> pq;
    private Map<Integer, Integer> taskPri;
    private Map<Integer, Integer> taskOwner;

    public DesignTaskManager(List<List<Integer>> tasks) {
        pq = new PriorityQueue<>((a, b) -> {
            if (b[0] != a[0])
                return b[0] - a[0];
            return b[1] - a[1];
        });
        taskPri = new HashMap<>();
        taskOwner = new HashMap<>();
        for (List<Integer> t : tasks)
            add(t.get(0), t.get(1), t.get(2));
    }

    public void add(int userId, int taskId, int priority) {
        pq.add(new int[] { priority, taskId });
        taskPri.put(taskId, priority);
        taskOwner.put(taskId, userId);
    }

    public void edit(int taskId, int newPriority) {
        pq.add(new int[] { newPriority, taskId });
        taskPri.put(taskId, newPriority);
    }

    public void rmv(int taskId) {
        taskPri.put(taskId, -1);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int p = t[0], id = t[1];
            if (taskPri.getOrDefault(id, -2) == p) {
                taskPri.put(id, -1);
                return taskOwner.getOrDefault(id, -1);
            }
        }
        return -1;
    }
}
