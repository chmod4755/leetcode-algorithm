package top.lighten.leetcode.editor.cn;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        System.out.println("Start: " + Arrays.toString(array));
        modifyArray(array);
        System.out.println("After: " + Arrays.toString(array));
    }

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & 1 << i) == 0 ? "0" : "1");
        }
        System.out.print("\n");
    }

    public static void modifyArray(int[] array) {
        array[1] = 9;
        System.out.println("Modify Function: " + Arrays.toString(array));
    }
}