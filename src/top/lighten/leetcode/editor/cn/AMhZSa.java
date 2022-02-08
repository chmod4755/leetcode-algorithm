//给定一个链表的 头节点 head ，请判断其是否为回文链表。 
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 23 👎 0


package top.lighten.leetcode.editor.cn;

public class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
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
        public boolean isPalindrome(ListNode head) {
            if (head.next == null) {
                return true;
            }
            //找到中点slow，start为后半部起点，截断slow.next
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode start = slow.next;
            slow.next = null;
            //翻转后半部
            ListNode next;
            ListNode ahead = null;
            while (start != null) {
                next = start.next;
                start.next = ahead;
                ahead = start;
                start = next;
            }
            //判断，遍历长度短的后半部分
            while (ahead != null) {
                if (ahead.val != head.val) {
                    return false;
                }
                ahead = ahead.next;
                head = head.next;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}