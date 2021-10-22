//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 👍 5 👎 0


package top.lighten.leetcode.editor.cn;

public class JFETK5 {
    public static void main(String[] args) {
        Solution solution = new JFETK5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            if (a.length() < b.length()) {
                String c = b;
                b = a;
                a = c;
            }
            StringBuilder sa = new StringBuilder(a).reverse();
            StringBuilder sb = new StringBuilder(b).reverse();
            char bit = '0';
            for (int i = 0; i < sa.length(); i++) {
                char cb = '0';
                if (i < sb.length()) {
                    cb = sb.charAt(i);
                }
                char ca = sa.charAt(i);
                if (bit == '1') {
                    if (ca == cb) {
                        sa.setCharAt(i, '1');
                        if (cb == '0') {
                            bit = '0';
                        }
                    } else {
                        sa.setCharAt(i, '0');
                    }
                } else {
                    if (ca == cb) {
                        if (cb == '1') {
                            sa.setCharAt(i, '0');
                            bit = '1';
                        }
                    } else {
                        sa.setCharAt(i, '1');
                    }
                }
            }

            if (bit == '1') {
                sa.append('1');
            }
            return sa.reverse().toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}