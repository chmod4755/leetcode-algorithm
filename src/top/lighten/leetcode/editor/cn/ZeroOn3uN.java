//给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "10203040"
//输出：["10.20.30.40","102.0.30.40","10.203.0.40"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
//
// 
//
// 注意：本题与主站 93 题相同：https://leetcode-cn.com/problems/restore-ip-addresses/ 
// Related Topics 字符串 回溯 👍 15 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ZeroOn3uN {
    public static void main(String[] args) {
        Solution solution = new ZeroOn3uN().new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private String str = null;

        public List<String> restoreIpAddresses(String s) {
            str = s;
            List<String> result = new ArrayList<>();
            if (s.length() < 4 || s.length() > 12) {
                return result;
            }
            for (int i = 1; i < s.length(); i++) {
                if (i > 3) break;
                for (int j = i + 1; j < s.length(); j++) {
                    if (j - i > 3) break;
                    for (int k = j + 1; k < s.length(); k++) {
                        if (k - j > 3) break;
                        String ip = getIp(i, j, k);
                        if (ip != null) {
                            result.add(ip);
                        }
                    }
                }
            }
            return result;
        }

        private String getIp(int i, int j, int k) {
            StringBuilder sb = new StringBuilder();

            String part = str.substring(0, i);
            if ((part.charAt(0) == '0' && part.length() > 1) || Integer.parseInt(part) > 255) return null;
            sb.append(part).append('.');
            part = str.substring(i, j);
            if ((part.charAt(0) == '0' && part.length() > 1) || Integer.parseInt(part) > 255) return null;
            sb.append(part).append('.');
            part = str.substring(j, k);
            if ((part.charAt(0) == '0' && part.length() > 1) || Integer.parseInt(part) > 255) return null;
            sb.append(part).append('.');
            part = str.substring(k);
            if ((part.charAt(0) == '0' && part.length() > 1) || Integer.parseInt(part) > 255) return null;
            sb.append(part);
            return sb.toString();
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}