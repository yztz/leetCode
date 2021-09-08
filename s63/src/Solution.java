import java.util.*;

/* https://leetcode-cn.com/problems/ipo/  */
public class Solution {

    static class Item {
        int profit;
        int capital;

        Item(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Item> items = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            items.add(new Item(profits[i], capital[i]));
        }
        items.sort(Comparator.comparingInt(a -> a.capital));

        PriorityQueue<Item> pq = new PriorityQueue<>((x, y) -> y.profit - x.profit);
        int curr = 0;
        for (int i = 1; i <= k; i++) {
           while (curr < n && items.get(curr).capital <= w) {
               pq.add(items.get(curr));
               curr++;
           }
           if (!pq.isEmpty()) {
               w += pq.poll().profit;
           } else {
               break;
           }
        }

        return w;
    }
}
