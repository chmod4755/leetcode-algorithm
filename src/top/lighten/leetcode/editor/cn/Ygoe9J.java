//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。 
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。 
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
// 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 示例 4： 
//
// 
//输入: candidates = [1], target = 1
//输出: [[1]]
// 
//
// 示例 5： 
//
// 
//输入: candidates = [1], target = 2
//输出: [[1,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
//
// 
//
// 注意：本题与主站 39 题相同： https://leetcode-cn.com/problems/combination-sum/ 
// Related Topics 数组 回溯 👍 3 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ygoe9J {
    public static void main(String[] args) {
        Solution solution = new Ygoe9J().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            return combinationSum(candidates, 0, target);
        }

        public List<List<Integer>> combinationSum(int[] candidates, int index, int target) {
            if (index >= candidates.length) {
                return null;
            }
            List<List<Integer>> resultList = new ArrayList<>();
            int candidate = candidates[index];
            ArrayList<Integer> thisList;
            for (int j = target / candidate; j >= 0; j--) {

                if (target == j * candidate) {
                    thisList = new ArrayList<>();
                    for (int i = 0; i < j; i++) {
                        thisList.add(candidate);
                    }
                    resultList.add(thisList);
                } else {
                    List<List<Integer>> lastResultList = combinationSum(candidates, index + 1, target - j * candidate);
                    if (lastResultList != null) {
                        thisList = new ArrayList<>();
                        for (int i = 0; i < j; i++) {
                            thisList.add(candidate);
                        }
                        for (List<Integer> result : lastResultList) {
                            result.addAll(thisList);
                            resultList.add(result);
                        }
                    }

                }
            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}