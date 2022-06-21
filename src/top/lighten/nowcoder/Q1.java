package top.lighten.nowcoder;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] intArray = str.split(",");
            for (int j = 0; j < intArray.length; j++) {
                matrix[i][j] = Integer.parseInt(intArray[j]);
            }


        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int maxV = 0;
            for (int j = 0; j < n; j++) {
                int sumT = 0;
                for (int k = 0; k < n; k++) {
                    int index = k + j;
                    if (index >= n) {
                        index = index - n;
                    }
                    sumT += matrix[i][index] * (1 << Math.abs(n - k - 1));
                }
                maxV = Math.max(maxV, sumT);
            }
            sum += maxV;
        }
        System.out.println(sum);
    }

}
