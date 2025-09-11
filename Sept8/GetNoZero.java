class GetNoZero {
    // Helper method to check if a number contains zero
    private boolean containsZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) return true;
            num /= 10;
        }
        return false;
    }
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int a = i;
            int b = n - i;
            // Check both integers for zero digits
            if (!containsZero(a) && !containsZero(b)) {
                return new int[]{a, b};
            }
        }
        // Problem guarantees at least one solution
        return new int[]{};
    }
}
