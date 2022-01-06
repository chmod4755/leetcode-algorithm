//给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：能尝试使用一趟扫描实现吗？ 
//
// 
//
// 注意：本题与主站 19 题相同： https://leetcode-cn.com/problems/remove-nth-node-from-end-
//of-list/ 
// Related Topics 链表 双指针 👍 21 👎 0


package top.lighten.leetcode.editor.cn;

import java.util.ArrayList;

public class SLwz0R {
    public static void main(String[] args) {

        Solution solution = new SLwz0R().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head.next == null) {
                return null;
            }
            ListNode start = head;
            ListNode end = head;
            while (end.next != null) {
                end = end.next;
                if (n > 0) {
                    --n;
                } else {
                    start = start.next;
                }
            }
            if (n > 0) {
                return start.next;
            }
            start.next = start.next.next;
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}