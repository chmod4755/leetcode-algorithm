//给定一个可能有重复数字的整数数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合
//。 
//
// candidates 中的每个数字在每个组合中只能使用一次，解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// 
//
// 注意：本题与主站 40 题相同： https://leetcode-cn.com/problems/combination-sum-ii/ 
// Related Topics 数组 回溯 👍 2 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FourSjJUc {
    public static void main(String[] args) {
        Solution solution = new FourSjJUc().new Solution();
        solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(solution.alreadyList.get(4).toString());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private List<List<Integer>> resultList = new ArrayList<>();
        private List<Integer> result = new ArrayList<>();
        private List<String> alreadyList = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            combinationSum(candidates, 0, target);
            return resultList;
        }

        public void combinationSum(int[] candidates, int index, int target) {
            if (index >= candidates.length) {
                return;
            }
            int candidate = candidates[index];
            if (target >= candidate) {
                result.add(candidate);
                if (target == candidate) {
                    String stringResult = result.stream().sorted().collect(Collectors.toList()).toString();
                    if (!alreadyList.contains(stringResult)) {
                        alreadyList.add(stringResult);
                        resultList.add(new ArrayList<>(result));
                    }
                } else {
                    combinationSum(candidates, index + 1, target - candidate);
                }
                result.remove(result.size() - 1);
                combinationSum(candidates, index + 1, target);
            } else {
                combinationSum(candidates, index + 1, target);
            }
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
}
