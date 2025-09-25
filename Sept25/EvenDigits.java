package Sept25;

public class EvenDigits {
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int n : nums) {
            int num = countDigits(n);
            if (num % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    private int countDigits(int num) {
        int count = 0;
        while (num > 0) {
            int digit = num % 10;
            count++;
            num = num / 10;
        }
        return count;
    }
}
