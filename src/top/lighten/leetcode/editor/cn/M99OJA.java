//给定一个字符串 s ，请将 s 分割成一些子串，使每个子串都是 回文串 ，返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "google"
//输出：[["g","o","o","g","l","e"],["g","oo","g","l","e"],["goog","l","e"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出：[["a"]  
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 131 题相同： https://leetcode-cn.com/problems/palindrome-partitioning/ 
// Related Topics 字符串 动态规划 回溯 👍 9 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class M99OJA {
    public static void main(String[] args) {
        Solution solution = new M99OJA().new Solution();
        solution.partition("google");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private StringBuilder current = new StringBuilder();
        private List<String> currentResult = new ArrayList<>();
        private List<List<String>> result = new ArrayList<>();
        private String source;

        public String[][] partition(String s) {
            this.source = s;
            dfs(0);
            String[][] allResult = new String[result.size()][];
            for (int i = 0; i < result.size(); i++) {
                List<String> oneResult = result.get(i);
                allResult[i] = oneResult.toArray(new String[]{});
            }
            return allResult;
        }

        public boolean dfs(int index) {
            current.append(source.charAt(index));
            if (isLegal(current)) {
                currentResult.add(current.toString());
                if (index == source.length() - 1) {
                    currentResult.add(current.toString());
                    result.add(currentResult);
                }
                for (int i = index + 1; i < source.length(); i++) {
                    if (dfs(i)) {
                        currentResult.remove(currentResult.size() - 1);
                    }
                    current = new StringBuilder();

                }
                return true;
            }
            return false;
        }

        public boolean isLegal(StringBuilder subStr) {
            if (subStr.length() == 1) {
                return true;
            }
            boolean legal = true;
            for (int i = 0; i < subStr.length() / 2; i++) {
                if (subStr.charAt(i) != subStr.charAt(subStr.length() - i - 1)) {
                    legal = false;
                    break;
                }
            }
            return legal;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}