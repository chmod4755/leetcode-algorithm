//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 👍 7 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class VvJkup {
    public static void main(String[] args) {
        Solution solution = new VvJkup().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] nums;
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            this.nums = nums;
            this.used = new boolean[nums.length];
            dfs();
            return resList;
        }

        public void dfs() {
            if (path.size() == this.nums.length) {
                resList.add(new ArrayList<>(path));
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
    }
//leetcode submit region end(Prohibit modification and deletion)

    class MySolution {
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> plist = new ArrayList<>(nums.length);
            for (int num : nums) {
                plist.add(num);
            }
            return permute(plist);
        }

        public List<List<Integer>> permute(List<Integer> plist) {
            List<List<Integer>> resList = new ArrayList<>();
            if (plist.size() == 1) {
                List<Integer> res = new ArrayList<>();
                res.add(plist.get(0));
                resList.add(res);
            } else {
                for (int i = 0; i < plist.size(); i++) {
                    List<Integer> nlist = new ArrayList<>(plist);
                    nlist.remove(i);
                    for (List<Integer> res : permute(nlist)) {
                        res.add(plist.get(i));
                        resList.add(res);
                    }
                }
            }
            return resList;
        }
    }

}