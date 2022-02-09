//给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。 
//
// 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// 
//
// 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/ 
// Related Topics 哈希表 字符串 排序 👍 15 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sfvd7V {
    public static void main(String[] args) {
        Solution solution = new Sfvd7V().new Solution();
//        System.out.println((char) ('a' + 2));
        System.out.println(solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Map<String, List<String>> map = new HashMap<>();

        public List<List<String>> groupAnagrams(String[] strs) {
            int[] nums;
            for (String str : strs) {
                nums = new int[26];
                for (int i = 0; i < str.length(); i++) {
                    nums[str.charAt(i) - 'a']++;
                }
                StringBuilder key = new StringBuilder();
                for (int i = 0; i < 26; i++) {
                    if (nums[i] > 0) {
                        key.append((char) ('a' + i)).append(nums[i]);
                    }
                }
                List<String> strList = map.computeIfAbsent(key.toString(), k -> new ArrayList<>());
                strList.add(str);
            }
            return new ArrayList<>(map.values());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}