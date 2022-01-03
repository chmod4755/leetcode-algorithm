//给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 可以删除 "c" 字符 或者 "b" 字符
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 680 题相同： https://leetcode-cn.com/problems/valid-palindrome-ii/ 
// Related Topics 贪心 双指针 字符串 👍 18 👎 0


package top.lighten.leetcode.editor.cn;

public class RQku0D {
    public static void main(String[] args) {
        Solution solution = new RQku0D().new Solution();
        System.out.println(solution.validPalindrome("abca"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int end = s.length() - 1;
            int start = 0;
            while (start < end) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else {
                    if (isPalindrome(s.substring(start, end))) {
                        return true;
                    } else return isPalindrome(s.substring(start + 1, end + 1));
                }
            }
            return true;
        }

        private boolean isPalindrome(String s) {
            int end = s.length() - 1;
            int start = 0;
            while (start < end) {
                if (s.charAt(start) == s.charAt(end)) {
                    start++;
                    end--;
                } else {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}