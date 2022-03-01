//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
//
// 
//
// 注意：本题与主站 539 题相同： https://leetcode-cn.com/problems/minimum-time-difference/ 
// Related Topics 数组 数学 字符串 排序 👍 9 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Five69nqc {
    public static void main(String[] args) {
        Solution solution = new Five69nqc().new Solution();
        List<String> list = new ArrayList<>();
        list.add("23:59");
//        list.add("10:51");
        list.add("00:00");
//        list.add("10:01");
//        list.add("00:01");
        System.out.println(solution.findMinDifference(list));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            Collections.sort(timePoints);
            int forward = getMinutes(timePoints.get(0));
            int minM = 24 * 60 - getMinutes(timePoints.get(timePoints.size() - 1)) + forward;
            for (int i = 1; i < timePoints.size(); i++) {
                int current = getMinutes(timePoints.get(i));
                minM = Math.min(minM, current - forward);
                forward = current;
            }
            return Math.min(minM, getMinutes(timePoints.get(timePoints.size() - 1)));
        }

        private int getMinutes(String time) {
            return 60 * Integer.parseInt(time.substring(0, 2)) + Integer.parseInt(time.substring(3, 5));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}