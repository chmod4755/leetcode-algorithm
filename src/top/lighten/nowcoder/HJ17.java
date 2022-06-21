package top.lighten.nowcoder;

import java.util.Scanner;

public class HJ17 {
    public static void main(String[] args) {
        int x = 0, y = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] steps = str.split(";");
        for (String step : steps) {
            if (step.length() > 1) {
                char target = step.charAt(0);
                int len = 0;
                try {
                    len = Integer.parseInt(step.substring(1));
                } catch (NumberFormatException e) {
                    continue;
                }
                switch (target) {
                    case 'W': {
                        y += len;
                        break;
                    }
                    case 'A': {
                        x -= len;
                        break;
                    }
                    case 'S': {
                        y -= len;
                        break;
                    }
                    case 'D': {
                        x += len;
                        break;
                    }
                    default:
                        break;
                }
            }
        }
        System.out.print(x + "," + y);
    }
}
