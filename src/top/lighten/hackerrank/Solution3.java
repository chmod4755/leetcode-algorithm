package top.lighten.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution3 {
    public static long maximumProfit(List<Integer> inventory, long order) {
        // Write your code here
        Collections.sort(inventory);
        int[] numbers = new int[inventory.get(inventory.size() - 1) + 1];
        int previous = -1;
        long profit = 0;
        for (int i = 0; i < inventory.size(); i++) {
            int current = inventory.get(i);
            if (current != previous) {
                previous = current;
                int leftNum = inventory.size() - i;
                while (current > 0 && numbers[current] == 0) {
                    numbers[current] = leftNum;
                    current--;
                }
            }
        }
        for (int i = numbers.length - 1; i > 0; i--) {
            if (order > numbers[i]) {
                order -= numbers[i];
                profit += (long) i * numbers[i];
            } else {
                profit += i * order;
                break;
            }
        }
        return profit;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int inventoryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> inventory = IntStream.range(0, inventoryCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        long order = Long.parseLong(bufferedReader.readLine().trim());

        long result = maximumProfit(inventory, order);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
