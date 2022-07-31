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


class Pair {
    long number;
    long value;

    public Pair(long number, long value) {
        this.number = number;
        this.value = value;
    }
}

public class Solution1 {

    public static long getMaxUnits(List<Long> boxes, List<Long> unitsPerBox, long truckSize) {
        // Write your code here
        List<Pair> products = new ArrayList<>();
        for (int i = 0; i < boxes.size(); i++) {
            products.add(new Pair(boxes.get(i), unitsPerBox.get(i)));
        }
        products.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (int) (o2.value - o1.value);
            }
        });
        long maxUnits = 0;
        for (Pair pair : products) {
            if (truckSize > pair.number) {
                maxUnits += pair.number * pair.value;
                truckSize -= pair.number;
            } else {
                maxUnits += truckSize * pair.value;
                break;
            }
        }
        return maxUnits;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int boxesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> boxes = IntStream.range(0, boxesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Long::parseLong)
                .collect(toList());

        int unitsPerBoxCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Long> unitsPerBox = IntStream.range(0, unitsPerBoxCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Long::parseLong)
                .collect(toList());

        long truckSize = Long.parseLong(bufferedReader.readLine().trim());

        long result = getMaxUnits(boxes, unitsPerBox, truckSize);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
