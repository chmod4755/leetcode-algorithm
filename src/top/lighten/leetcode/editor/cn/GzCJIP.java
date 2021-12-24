//数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。 
//
// 每当爬上一个阶梯都要花费对应的体力值，一旦支付了相应的体力值，就可以选择向上爬一个阶梯或者爬两个阶梯。 
//
// 请找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。 
//
// 
//
// 示例 1： 
//
// 
//输入：cost = [10, 15, 20]
//输出：15
//解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
// 
//
// 示例 2： 
//
// 
//输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
//输出：6
//解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= cost.length <= 1000 
// 0 <= cost[i] <= 999 
// 
//
// 
//
// 注意：本题与主站 746 题相同： https://leetcode-cn.com/problems/min-cost-climbing-stairs/ 
//
// Related Topics 数组 动态规划 👍 16 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.Arrays;

public class GzCJIP {
    public static void main(String[] args) {
        Solution solution = new GzCJIP().new Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] fare = null;
        int[] eachMinCost = null;

        public int minCostClimbingStairs(int[] cost) {
            fare = cost;
            eachMinCost = new int[cost.length + 1];
            Arrays.fill(eachMinCost, -1);
            eachMinCost[0] = 0;
            eachMinCost[1] = 0;
            return getMinCost(cost.length);
        }

        private int getMinCost(int index) {
            int minCost = eachMinCost[index];
            if (minCost >= 0) {
                return minCost;
            } else {
                minCost = Math.min(getMinCost(index - 1) + fare[index - 1], getMinCost(index - 2) + fare[index - 2]);
            }
            eachMinCost[index] = minCost;
            return minCost;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}