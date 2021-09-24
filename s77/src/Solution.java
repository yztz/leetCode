/* https://leetcode-cn.com/problems/split-linked-list-in-parts/ */
public class Solution {

    static class ListNode {
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

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLength(head);
        int base = len / k;
        int rest = len % k;
        ListNode[] answer = new ListNode[k];
        for (int i = 0; i < k && head != null; i++) {
            ListNode tmp = head;
            ListNode pre = head;
            for (int j = 0; j < base; j++) {
                pre = head;
                head = head.next;
            }
            if (i < rest) {
                pre = head;
                head = head.next;
            }
            pre.next = null;

            answer[i] = tmp;
        }

        return answer;
    }

    public int getLength(ListNode node) {
        ListNode curr = node;
        int length = 0;
        while (null != curr) {
            curr = curr.next;
            length++;
        }

        return length;
    }
}
