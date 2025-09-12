class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int horStart = 0;
        int horEnd = matrix[0].length;
        int verStart = 0;
        int verEnd = matrix.length;
        int n = verEnd * horEnd;
        verEnd--;
        horEnd--;
        List<Integer> result = new ArrayList<>();
        while (n > 0) {

            // from left top to right
            for (int i = horStart; i <= horEnd; i++) {
                result.add(matrix[verStart][i]);
                n--;
            }
            verStart++;

            if (n <= 0)
                break;

            // from right top to bottom
            for (int i = verStart; i <= verEnd; i++) {
                result.add(matrix[i][horEnd]);
                n--;
            }
            horEnd--;

            if (n <= 0)
                break;

            // right bottom to left
            for (int i = horEnd; i >= horStart; i--) {
                result.add(matrix[verEnd][i]);
                n--;
            }
            verEnd--;

            if (n <= 0)
                break;

            // left bottom to right
            for (int i = verEnd; i >= verStart; i--) {
                result.add(matrix[i][horStart]);
                n--;
            }
            horStart++;
        }
        return result;
    }
}