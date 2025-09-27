public class MiniLenString {
    public int minLenString(String s) {
        int totalLen = 0;
        int[] charFreq = new int[26];
        for (char c : s.toCharArray()) {
            charFreq[c - 'a']++;
        }
        for (int n : charFreq) {
            if (n == 0) {
                continue;
            }
            if (n % 2 == 0) {
                totalLen += 2;
            } else {
                totalLen += 1;
            }
        }
        return totalLen;
    }
}
