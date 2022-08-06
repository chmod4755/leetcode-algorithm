package top.lighten.oj;

import java.util.Arrays;

public class GetTheNumber {

    public static final int NUM = 100000;

    public static void main(String[] args) {
        int[] numbers = new int[NUM];
        numbers[0] = 2;
        int index = 1;
        int number = 3;
        //平方根
        int maxNumber = 2;
        int PowNumber = maxNumber * maxNumber;
        while (index < NUM) {
            boolean isNumber = true;
            if (PowNumber < number) {
                maxNumber++;
                PowNumber = maxNumber * maxNumber;
            }
            for (int i = 0; i < index && numbers[i] < maxNumber; i++) {
                if (number % numbers[i] == 0) {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {
                numbers[index] = number;
                index++;
            }
            number++;
        }
        System.out.println(numbers[NUM - 1]);
    }

}
