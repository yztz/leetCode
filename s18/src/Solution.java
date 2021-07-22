import java.util.HashMap;
import java.util.Map;

/* https://leetcode-cn.com/problems/copy-list-with-random-pointer/  */
public class Solution {

    public static void main(String[] args) {
        Node head = new Node(7);
        head.random = null;
        head.next = new Node(13);
        head.next.random = head;
        head.next.next = null;
        Node n = new Solution().copyRandomList(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);
        Node ret = new Node(head.val);
        map.put(head, ret);
        ret.next = copyRandomList(head.next);
        ret.random = copyRandomList(head.random);
        return ret;
    }
}
