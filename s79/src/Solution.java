/* https://leetcode-cn.com/problems/flatten-a-multilevel-doubly-linked-list/  */
public class Solution {


    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        if (head == null) return null;

        Node answer = flattenOne(head);
        answer.prev = null;
        return answer;
    }

    public Node flattenOne(Node head) {
        Node cur = head;

        while (cur.next != null) {
            if (cur.child != null) {
                Node child = flattenOne(cur.child);
                Node last = child.prev;

                cur.next.prev = last;
                last.next = cur.next;

                cur.next = child;
                child.prev = cur;

                cur.child = null;
                cur = last;
            }
            cur = cur.next;
        }

        if (cur.child != null) {
            System.out.println("hoo");
            cur.next = flattenOne(cur.child);
            head.prev = cur.next.prev;
            cur.next.prev = cur;

            cur.child = null;
        } else {
            head.prev = cur;
        }

        return head;
    }


}
