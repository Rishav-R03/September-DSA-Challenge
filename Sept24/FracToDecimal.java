package Sept24;

import java.util.HashMap;
import java.util.Map;

public class FracToDecimal {
    public String fract2Dec(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        StringBuilder fraction = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            fraction.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        fraction.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0)
            return fraction.toString();
        fraction.append(".");
        Map<Long, Integer> rempos = new HashMap<>();
        while (remainder != 0) {
            if (rempos.containsKey(remainder)) {
                fraction.insert(rempos.get(remainder), "(");
                fraction.append(")");
                break;
            }
            rempos.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(remainder / divisor);
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
