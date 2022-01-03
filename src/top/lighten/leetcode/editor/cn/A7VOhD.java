//给定一个字符串 s ，请计算这个字符串中有多少个回文子字符串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 647 题相同：https://leetcode-cn.com/problems/palindromic-substrings/ 
// Related Topics 字符串 动态规划 👍 21 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.Arrays;

public class A7VOhD {
    public static void main(String[] args) {
        Solution solution = new A7VOhD().new Solution();
        System.out.println(solution.countSubstrings("aaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            boolean[] array1 = new boolean[s.length()];
            boolean[] array2 = new boolean[s.length()];
            Arrays.fill(array1, true);
            Arrays.fill(array2, true);
            int count = s.length();
            boolean[] array;
            for (int i = 1; i < s.length(); i++) {
                if (i % 2 == 1) {
                    array = array1;
                } else {
                    array = array2;
                }
                for (int j = 0; j < s.length() - i; j++) {
                    if (array[j + 1] && s.charAt(j) == s.charAt(j + i)) {
                        count++;
                        array[j] = true;
                    } else {
                        array[j] = false;
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}