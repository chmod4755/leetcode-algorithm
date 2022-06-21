package top.lighten.nowcoder;

import java.util.Scanner;

public class HJ75 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        String longS;
        String shortS;
        if (s1.length() > s2.length()) {
            longS = s1;
            shortS = s2;
        } else {
            longS = s2;
            shortS = s1;
        }
        int maxL = 0;
        int[] equalNum = new int[longS.length()];
        for (int i = 0; i < shortS.length(); i++) {
            for (int j = 0; j < shortS.length(); j++) {
                int index = i + j;
                if (index >= shortS.length()) {
                    break;
                }
                char c = shortS.charAt(index);
                for (int k = j; k < longS.length(); k++) {
                    if (longS.charAt(k) == c) {
                        equalNum[k - j] = equalNum[k - j] + 1;
                        maxL = Math.max(maxL, equalNum[k - j]);
                    } else {
                        equalNum[k - j] = 0;
                    }
                }
            }
        }
        System.out.println(maxL);
    }
}
