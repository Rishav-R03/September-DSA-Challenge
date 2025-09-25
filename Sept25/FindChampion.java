package Sept25;

import java.util.Scanner;

public class FindChampion {
    public static int findChampion(int[][] grid) {
        int maxWins = -1;
        int champIdx = -1;
        for (int i = 0; i < grid.length; i++) {
            int curWin = 0;
            int[] curTeam = grid[i];
            for (int j = 0; j < curTeam.length; j++) {
                curWin += grid[i][j];
            }
            if (curWin > maxWins) {
                maxWins = curWin;
                champIdx = i;
            }
        }
        return champIdx;
    }

    public static void main(String[] args) {
        System.out.println("enter grid size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("enter grid: ");
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int inp = sc.nextInt();
                grid[i][j] = inp;
            }
        }
        int out = findChampion(grid);
        System.out.println("The winner team is: " + out);
        sc.close();
    }
}
