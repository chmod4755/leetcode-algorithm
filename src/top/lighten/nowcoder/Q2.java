package top.lighten.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 2 || n > 99) {
            System.out.println("ERROR!");
        } else {
            Node first = new Node(1, null);
            Node last = first;
            int count = 0;
            for (int i = 2; i < 101; i++) {
                last.next = new Node(i, null);
                last = last.next;
            }
            last.next = first;
            Node start = new Node(0, first);
            while (count < (100 - n + 1)) {
                for (int i = 0; i < n - 1; i++) {
                    start = start.next;
                }
                start.next = start.next.next;
                count++;
            }
            first = start;
            ArrayList<Integer> list = new ArrayList<>();
            do {
                list.add(start.value);
                start = start.next;
            } while (start != first);

            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            Arrays.sort(res);
            StringBuilder sb = new StringBuilder();
            for (int re : res) {
                sb.append(re).append(",");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }
    }
}
