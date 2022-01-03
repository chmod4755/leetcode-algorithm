//给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 本题中，将空字符串定义为有效的 回文串 。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出: true
//解释："amanaplanacanalpanama" 是回文串 
//
// 示例 2: 
//
// 
//输入: s = "race a car"
//输出: false
//解释："raceacar" 不是回文串 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// 字符串 s 由 ASCII 字符组成 
// 
//
// 
//
// 注意：本题与主站 125 题相同： https://leetcode-cn.com/problems/valid-palindrome/ 
// Related Topics 双指针 字符串 👍 13 👎 0


package top.lighten.leetcode.editor.cn;

public class XltzEq {
    public static void main(String[] args) {
        Solution solution = new XltzEq().new Solution();
        System.out.println(solution.isPalindrome("race a car"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            int end = s.length() - 1;
            int start = 0;
            int convert = 'a' - 'A';
            while (start < end) {
                int cs = s.charAt(start);
                if (!((cs >= '0' && cs <= '9') || (cs >= 'a' && cs <= 'z') || (cs >= 'A' && cs <= 'Z'))) {
                    start++;
                    continue;
                }
                int ce = s.charAt(end);
                if (!((ce >= '0' && ce <= '9') || (ce >= 'a' && ce <= 'z') || (ce >= 'A' && ce <= 'Z'))) {
                    end--;
                    continue;
                }
                if (cs >= 'A' && cs <= 'Z') {
                    cs = cs + convert;
                }
                if (ce >= 'A' && ce <= 'Z') {
                    ce = ce + convert;
                }

                if (cs == ce) {
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