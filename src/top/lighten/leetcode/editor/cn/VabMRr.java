//给定两个字符串 s 和 p，找到 s 中所有 p 的 变位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 变位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的变位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的变位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的变位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的变位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的变位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 438 题相同： https://leetcode-cn.com/problems/find-all-anagrams-in-a-
//string/ 
// Related Topics 哈希表 字符串 滑动窗口 👍 8 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VabMRr {
    public static void main(String[] args) {
        Solution solution = new VabMRr().new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new ArrayList<>();
            char zero = 'a';
            int[] charNum = new int[26];
            int[] copy;
            boolean[] hasChar = new boolean[26];
            int length = p.length();
            int count = length;
            for (int i = 0; i < length; i++) {
                int index = p.charAt(i) - zero;
                charNum[index]++;
                hasChar[index] = true;
            }
            int start = 0;
            int end = -1;
            copy = Arrays.copyOf(charNum, charNum.length);
            while (end < s.length() - 1) {
                end++;
                int endIndex = s.charAt(end) - zero;

                if (!hasChar[endIndex]) {
                    start = end + 1;
                    if (count != length) {
                        count = length;
                        copy = Arrays.copyOf(charNum, charNum.length);
                    }
                    continue;
                }
                copy[endIndex]--;
                if (copy[endIndex] >= 0) {
                    count--;
                }

                if (end - start + 1 < length) {
                    continue;
                }
                if (count == 0) {
                    result.add(start);
                }
                int startIndex = s.charAt(start) - zero;
                copy[startIndex]++;
                if (copy[startIndex] > 0) {
                    count++;
                }
                start++;
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}