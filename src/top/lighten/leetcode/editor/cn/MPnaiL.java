//给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。 
//
// 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s1 = "ab" s2 = "eidbaooo"
//输出: True
//解释: s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入: s1= "ab" s2 = "eidboaoo"
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 567 题相同： https://leetcode-cn.com/problems/permutation-in-string/ 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 21 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.Arrays;

public class MPnaiL {
    public static void main(String[] args) {
        Solution solution = new MPnaiL().new Solution();
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] charNum = new int[26];
            int count = s1.length();
            for (int i = 0; i < count; i++) {
                int index = s1.charAt(i) - 'a';
                charNum[index]++;
            }
            int[] copy = Arrays.copyOf(charNum, charNum.length);
            int start = 0, end = 0;
            while (end < s2.length()) {
                int endIndex = s2.charAt(end) - 'a';
                if (copy[endIndex] > 0) {
                    copy[endIndex]--;
                    count--;
                    if (count == 0) {
                        return true;
                    }
                    end++;
                } else {
                    if (charNum[endIndex] > 0) {
                        int startIndex;
                        do {
                            startIndex = s2.charAt(start) - 'a';
                            copy[startIndex] ++;
                            count++;
                            start++;
                        } while(startIndex != endIndex);
                    } else {
                        if (count != s1.length()) {
                            copy = Arrays.copyOf(charNum, charNum.length);
                            count = s1.length();
                        }
                        end++;
                        start = end;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}