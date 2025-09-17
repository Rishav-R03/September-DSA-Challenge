import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;

class NumberContainers {
    private Map<Integer, TreeSet<Integer>> numberToInd;
    private Map<Integer, Integer> indToNum;

    public NumberContainers() {
        numberToInd = new HashMap<>();
        indToNum = new HashMap<>();
    }

    public void change(int index, int number) {
        if (indToNum.containsKey(index)) {
            int prevNum = indToNum.get(index);
            numberToInd.get(prevNum).remove(index);
            if (numberToInd.get(prevNum).isEmpty()) {
                numberToInd.remove(prevNum);
            }
        }
        indToNum.put(index, number);
        numberToInd.putIfAbsent(number, new TreeSet<>());
        numberToInd.get(number).add(index);
    }

    public int find(int number) {
        if (numberToInd.containsKey(number)) {
            return numberToInd.get(number).first();
        }
        return -1;
    }
}