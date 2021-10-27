//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a ，b ，c ，使得 a + b + c = 0 ？请找出所有和为 0 且
//不重复 的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 注意：本题与主站 15 题相同：https://leetcode-cn.com/problems/3sum/ 
// Related Topics 数组 双指针 排序 👍 17 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OneFGaJU {
    public static void main(String[] args) {
        Solution solution = new OneFGaJU().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> resultList = new ArrayList<>();
            if (nums.length == 0) {
                return resultList;
            }
            Arrays.sort(nums);
            int i = 0, j = nums.length - 1;
            while ((j - i) > 1) {
                if (2 * nums[i] + nums[j] > 0) {
                    j--;
                    continue;
                }
                if (nums[i] + 2 * nums[j] < 0) {
                    i++;
                    continue;
                }
                int need = -(nums[i] + nums[j]);
                int index = Arrays.binarySearch(nums, i + 1, j, need);
                if (index >= 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(need);
                    result.add(nums[j]);
                    if (resultList.size() == 0 || !result.equals(resultList.get(resultList.size() - 1))) {
                        resultList.add(result);
                    }
                }
                if (need > 0) {
                    i++;
                } else {
                    j--;
                }

            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}