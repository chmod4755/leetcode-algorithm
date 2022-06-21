package top.lighten.nowcoder;

import java.util.ArrayList;
import java.util.Scanner;


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}


class Solution {
    ArrayList<Point> res = new ArrayList<>();
    int[][] maze;
    boolean hasRes = false;

    public Solution(int[][] maze) {
        this.maze = maze;
    }

    public void bfs(int x, int y, char direct) {
        res.add(new Point(x, y));
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            hasRes = true;
            return;
        }
        if (direct != 'T' && x + 1 < maze.length && maze[x + 1][y] == 0) {
            bfs(x + 1, y, 'D');
        }
        if (hasRes) return;
        if (direct != 'L' && y + 1 < maze[0].length && maze[x][y + 1] == 0) {
            bfs(x, y + 1, 'R');
        }
        if (hasRes) return;
        if (direct != 'D' && x - 1 >= 0 && maze[x - 1][y] == 0) {
            bfs(x - 1, y, 'T');
        }
        if (hasRes) return;
        if (direct != 'R' && y - 1 >= 0 && maze[x][y - 1] == 0) {
            bfs(x, y - 1, 'L');
        }
        if (hasRes) return;
        res.remove(res.size() - 1);
    }
}


public class HJ43 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        Solution solution = new Solution(maze);
        solution.bfs(0, 0, 'D');
        for (Point p : solution.res) {
            System.out.println(p);
        }
    }
}
