import java.util.List;
import java.util.ArrayList;

class GrayCode {
    public List<Integer> grayCode(int n) {
        int size = 1 << n; // 2 to power n
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }
}