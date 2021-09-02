/* https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/ 快慢指针 0ms */
public class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        int distance = 0;
        while (fast != null) {
            fast = fast.next;
            if (distance == k - 1) {
                slow = slow.next;
            } else distance++;
        }

        return slow;
    }
}
