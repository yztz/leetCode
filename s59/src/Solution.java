import java.util.Collections;
import java.util.PriorityQueue;

/* https://leetcode-cn.com/problems/smallest-k-lcci/ 摸鱼小根堆 */
public class Solution {


    public int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) queue.offer(i);
        int[] answers = new int[k];
        int pos = 0;
        while (pos < k) answers[pos++] = queue.poll();

        return answers;
    }
}
