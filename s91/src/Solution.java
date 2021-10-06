import java.util.*;

public class Solution {
//    public int thirdMax(int[] nums) {   // 输了，TreeSet没见过
//        TreeSet<Integer> s = new TreeSet<Integer>();
//        for (int num : nums) {
//            s.add(num);
//            if (s.size() > 3) {
//                s.remove(s.first());
//            }
//        }
//        return s.size() == 3 ? s.first() : s.last();
//    }

    public int thirdMax(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) map.put(num, true);
        Set<Integer> targets = map.keySet();
        if (targets.size() < 3) {
            Iterator<Integer> iter = targets.iterator();
            int max = iter.next();
            while (iter.hasNext()) max = Math.max(max, iter.next());
            return max;
        }

        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        for (int target : map.keySet()) {
            if (target >= c) {
                a = b;
                b = c;
                c = target;
            } else if (target >= b) {
                a = b;
                b = target;
            } else if (target >= a) {
                a = target;
            }
        }
        return a == b ? c : a;
    }
}
