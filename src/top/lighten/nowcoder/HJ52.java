package top.lighten.nowcoder;

import java.util.Scanner;

public class HJ52 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String origin = sc.nextLine();
        String target = sc.nextLine();
        if (origin.equals(target)) {
            System.out.println(0);
        }
        int[][] dp = new int[origin.length() + 1][target.length() + 1];
        for (int i = 0; i < target.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < origin.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < origin.length() + 1; i++) {
            for (int j = 1; j < target.length() + 1; j++) {
                if (origin.charAt(i - 1) == target.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1
                    );
                }

            }
        }
        System.out.println(dp[origin.length()][target.length()]);
    }
}
