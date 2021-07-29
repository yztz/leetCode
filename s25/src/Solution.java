import java.util.*;

/* https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/
    52ms
    可以结合数学优化 先进行 常规序列寻径 logN
    结合getReverse针对偶数行求反
*/
public class Solution {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        gen:
        for (int i = 1;; i++) {
            int start = (int) Math.pow(2, i - 1);
            int count = (int) Math.pow(2, i);
            if (i % 2 == 1)
                while (start < count) {
                    list.add(start++);
                    System.out.println(start - 1);
                    if (start > label) break gen;
                }
            else
                while (start < count) {
                    list.add(--count);
                    System.out.println(count);
                    if (count == label) break gen;
                }
        }
        List<Integer> ret = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0;) {
            ret.add(0, list.get(i));
            i = (i + 1) / 2 - 1;
        }

        return ret;
    }
}
