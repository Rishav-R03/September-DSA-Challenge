import java.util.ArrayList;

public class Perfect_Numbers {
    public boolean checkPerfectNumber(int num) {
        ArrayList<Integer> divisors = new ArrayList<>();
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                divisors.add(i);
            }
        }
        int sum = 0;
        for (int i = 0; i < divisors.size(); i++) {
            sum += divisors.get(i);
        }
        if (sum == num) {
            return true;
        }
        return false;
    }

}
