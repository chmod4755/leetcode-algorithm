//给定一个单链表 L 的头节点 head ，单链表 L 表示为： 
//
// L0 → L1 → … → Ln-1 → Ln 
//请将其重新排列后变为： 
//
// L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → … 
//
// 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: head = [1,2,3,4]
//输出: [1,4,2,3] 
//
// 示例 2: 
//
// 
//
// 
//输入: head = [1,2,3,4,5]
//输出: [1,5,2,4,3] 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 510⁴] 
// 1 <= node.val <= 1000 
// 
//
// 
//
// 注意：本题与主站 143 题相同：https://leetcode-cn.com/problems/reorder-list/ 
// Related Topics 栈 递归 链表 双指针 👍 25 👎 0


package top.lighten.leetcode.editor.cn;

public class LGjMqU {
    public static void main(String[] args) {
        Solution solution = new LGjMqU().new Solution();
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
        public void reorderList(ListNode head) {
            if (head.next == null) {
                return;
            }
            //计算总长度
            int count = 0;
            ListNode start = head;
            while (start != null) {
                ++count;
                start = start.next;
            }
            //寻找中点，截断链表
            count = count - count / 2;
            start = head;
            while (count > 1) {
                start = start.next;
                --count;
            }
            ListNode temp = start.next;
            start.next = null;
            start = temp;
            //翻转后部分链表
            ListNode ahead = null;
            ListNode next = start.next;
            while (next != null) {
                start.next = ahead;
                ahead = start;
                start = next;
                next = start.next;
            }
            start.next = ahead;
            //间隔插入后半部链表
            while (head != null && start != null) {
                next = head.next;
                head.next = start;
                start = start.next;
                head.next.next = next;
                head = next;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}