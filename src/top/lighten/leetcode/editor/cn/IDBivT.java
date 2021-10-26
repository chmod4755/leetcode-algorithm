//正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// 
//
// 注意：本题与主站 22 题相同： https://leetcode-cn.com/problems/generate-parentheses/ 
// Related Topics 字符串 动态规划 回溯 👍 10 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class IDBivT {
    public static void main(String[] args) {
        Solution solution = new IDBivT().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<String> resultList = new ArrayList<>();
        private StringBuilder path = new StringBuilder();
        private int total;

        public List<String> generateParenthesis(int n) {
            this.total = n;

            dfs(0, 0);
            return resultList;
        }

        public void dfs(int l, int r) {

            if (l > total || r > total || r > l) {
                return;
            }

            if (l + r == 2 * total) {
                resultList.add(path.toString());
            }


            path.append('(');
            dfs(l + 1, r);
            path.setCharAt(path.length() - 1, ')');
            dfs(l, r + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}