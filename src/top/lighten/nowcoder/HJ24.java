package top.lighten.nowcoder;

import java.util.Scanner;

public class HJ24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int max_remain = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] < height[i]) {
                    max_remain = Math.max(max_remain, left[j]);
                }
            }
            left[i] = max_remain + 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            int max_remain = 0;
            for (int j = i + 1; j < n; j++) {
                if (height[j] < height[i]) {
                    max_remain = Math.max(max_remain, right[j]);
                }
            }
            right[i] = max_remain + 1;
        }
        int max_remain = 0;
        for (int i = 0; i < n; i++) {
            max_remain = Math.max(max_remain, left[i] + right[i]);
        }
        System.out.println(n - max_remain + 1);
    }
}
