//请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不
//会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// 
//
// 注意：本题与主站 739 题相同： https://leetcode-cn.com/problems/daily-temperatures/ 
// Related Topics 栈 数组 单调栈 👍 28 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class IIQa4I {
    public static void main(String[] args) {
        Solution solution = new IIQa4I().new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class Pair {
            int key;
            int value;

            public Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        public int[] dailyTemperatures(int[] temperatures) {
            int[] result = new int[temperatures.length];

            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.empty()) {
                    if (temperatures[i] > stack.peek().value) {
                        Pair pair = stack.pop();
                        result[pair.key] = i - pair.key;
                    } else {
                        break;
                    }
                }
                stack.push(new Pair(i, temperatures[i]));
            }
            while (!stack.empty()) {
                Pair pair = stack.pop();
                result[pair.key] = 0;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}