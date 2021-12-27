//给定一个二维矩阵 matrix，以下类型的多个请求： 
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角
// (row2, col2) 的子矩阵的元素总和。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 最多调用 10⁴ 次 sumRegion 方法 
// 
//
// 
//
// 注意：本题与主站 304 题相同： https://leetcode-cn.com/problems/range-sum-query-2d-
//immutable/ 
// Related Topics 设计 数组 矩阵 前缀和 👍 14 👎 0


package top.lighten.leetcode.editor.cn;

public class O4NDxx {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{new int[]{3, 0, 1, 4, 2}, new int[]{5, 6, 3, 2, 1}, new int[]{1, 2, 0, 1, 5}, new int[]{4, 1, 0, 1, 7}, new int[]{1, 0, 3, 0, 5}};
        NumMatrix obj = new NumMatrix(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3));
        int[][] matrix2 = new int[][]{new int[]{8, -4, 5}, new int[]{-1, 4, 4}, new int[]{-2, 3, 1}, new int[]{-4, 4, 3}};
        NumMatrix obj2 = new NumMatrix(matrix2);
        System.out.println(obj2.sumRegion(0,0,0,1));
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    private int[][] answer;

    public NumMatrix(int[][] matrix) {
        answer = new int[matrix.length][matrix[0].length];
        answer[0][0] = matrix[0][0];
        for (int i = 1; i < answer[0].length; i++) {
            answer[0][i] = matrix[0][i] + answer[0][i - 1];
        }
        for (int i = 1; i < answer.length; i++) {
            answer[i][0] = matrix[i][0] + answer[i - 1][0];
        }
        for (int i = 1; i < answer.length; i++) {
            for (int j = 1; j < answer[0].length; j++) {
                answer[i][j] = matrix[i][j] + answer[i - 1][j] + answer[i][j - 1] - answer[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int curAnswer = answer[row2][col2];
        if (row1 == 0) {
            if (col1 == 0) {
                return curAnswer;
            }
            return curAnswer - answer[row2][col1 - 1];
        }
        if (col1 == 0) {
            return curAnswer - answer[row1 - 1][col2];
        }
        return answer[row2][col2] - answer[row2][col1 - 1] - answer[row1 - 1][col2] + answer[row1 - 1][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
