package top.lighten.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class HJ45 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = sc.nextLine();
        }
        int[] weight;
        for (String s : strArray) {
            weight = new int[26];
            for (int i = 0; i < s.length(); i++) {
                weight[s.charAt(i) - 'a']++;
            }
            Arrays.sort(weight);
            int total = 0;
            for (int i = 0; i < 26; i++) {
                total += weight[i] * (i + 1);
            }
            System.out.println(total);
        }
    }
}
