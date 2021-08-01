import java.util.*;

/* https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/ 3ms */
public class Solution {

    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, List<Integer>> combatNum = new HashMap<>();
        int len = mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            int[] row = mat[i];
            int count = 0;
            while (count < len && row[count] != 0) count++;
            combatNum.putIfAbsent(count, new ArrayList<>());
            combatNum.get(count).add(i);
        }
        List<Integer> res = new ArrayList<>();
        int combat = 0;
        while (res.size() < k) {
            if (combatNum.containsKey(combat)) {
                List<Integer> list = combatNum.get(combat);
                int t = 0;
                while (res.size() < k && t < list.size()) {
                    res.add(list.get(t));
                    t++;
                }
            }
            combat++;
        }

        return res.stream().mapToInt(o -> o).toArray();
    }
}
