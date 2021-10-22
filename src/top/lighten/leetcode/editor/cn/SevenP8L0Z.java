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
import java.util.Arrays;
import java.util.List;

public class SevenP8L0Z {
    public static void main(String[] args) {
        Solution solution = new SevenP8L0Z().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] nums;
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
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
                //因为遍历的过程中，永远都是从左到右遍历，举个例子1，1，2在第一次遍历的时候肯定不会存在重复，
                //当开始以第二个数作为第一个遍历的数的时候，buffer里面就会是false，true，false这种情况，
                //然后进行判断第一个数是1，并且used[1]是false，就说明1，1作为开头的子集在之前的一次遍历中已经用过了，所以就跳过判断。
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                path.add(nums[i]);
                used[i] = true;
                dfs();
                path.remove(path.size() - 1);
                used[i] = false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}