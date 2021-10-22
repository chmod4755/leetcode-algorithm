//给定一个可包含重复数字的整数集合 nums ，按任意顺序 返回它所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// 
//
// 注意：本题与主站 47 题相同： https://leetcode-cn.com/problems/permutations-ii/ 
// Related Topics 数组 回溯 👍 5 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SevenP8L0Z {
    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        HashSet<String> resSet = new HashSet<>();
        int[] nums;
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            this.nums = nums;
            this.used = new boolean[nums.length];
            dfs();
            return resList;
        }

        public void dfs() {
            if (path.size() == this.nums.length) {
                String pathStr = getPathStr();
                if (!resSet.contains(pathStr)) {
                    resSet.add(pathStr);
                    resList.add(new ArrayList<>(path));
                }
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs();
                path.remove(path.size() - 1);
                used[i] = false;
            }

        }

        public String getPathStr() {
            StringBuilder sb = new StringBuilder();
            path.forEach(integer -> {
                sb.append(integer);
                sb.append(',');
            });
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}