package top.lighten.hackerrank;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Discount {
    int type;
    int value;

    public Discount(String type, String value) {
        this.type = Integer.parseInt(type);
        this.value = Integer.parseInt(value);
    }
}

class Result {

    /*
     * Complete the 'findLowestPrice' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. 2D_STRING_ARRAY products
     *  2. 2D_STRING_ARRAY discounts
     */

    public static int findLowestPrice(List<List<String>> products, List<List<String>> discounts) {
        // Write your code here
        HashMap<String, Discount> discountMap = new HashMap<>();

        for (List<String> discount : discounts) {
            discountMap.put(discount.get(0), new Discount(discount.get(1), discount.get(2)));
        }
        int total = 0;
        for (List<String> product : products) {
            int price = Integer.parseInt(product.get(0));
            Discount direct = null;
            Discount percent = null;
            Discount fixed = null;
            int minPrice = price;

            for (int i = 1; i < product.size(); i++) {
                Discount discount = discountMap.get(product.get(i));
                if (discount != null) {
                    switch (discount.type) {
                        case 0:
                            if (direct == null || discount.value < direct.value) {
                                direct = discount;
                            }
                            break;
                        case 1:
                            if (percent == null || discount.value > percent.value) {
                                percent = discount;
                            }
                            break;
                        case 2:
                            if (fixed == null || discount.value > fixed.value) {
                                fixed = discount;
                            }
                            break;
                    }
                }
            }
            if (direct != null) {
                minPrice = direct.value;
            }
            if (percent != null) {
                minPrice = Math.min(minPrice, Math.round((price * (1 - percent.value / (float) 100))));
            }
            if (fixed != null) {
                minPrice = Math.min(minPrice, price - fixed.value);
            }
            total += minPrice;
        }
        return total;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int productsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int productsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> products = new ArrayList<>();

        IntStream.range(0, productsRows).forEach(i -> {
            try {
                products.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int discountsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int discountsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> discounts = new ArrayList<>();

        IntStream.range(0, discountsRows).forEach(i -> {
            try {
                discounts.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.findLowestPrice(products, discounts);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
