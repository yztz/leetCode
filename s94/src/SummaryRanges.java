import java.util.*;

public class SummaryRanges {

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public SummaryRanges() {

    }

    public void addNum(int val) {
        Map.Entry<Integer, Integer> interval0 = map.floorEntry(val);
        Map.Entry<Integer, Integer> interval1 = map.ceilingEntry(val + 1);
        if (interval0 != null) {
            if (interval0.getKey() <= val && interval0.getValue() >= val) {
                return;
            } else if (interval0.getValue() + 1 == val) {
                if (interval1 != null && interval1.getKey() == val + 1) {
                    map.remove(interval0.getKey());
                    map.remove(interval1.getKey());
                    map.put(interval0.getKey(), interval1.getValue());
                } else {
                    map.put(interval0.getKey(), val);
                }
                return;
            }
        }

        if (interval1 != null) {
            if (interval1.getKey() == val + 1) {
                map.remove(interval1.getKey());
                map.put(val, interval1.getValue());
                return;
            }
        }

        map.put(val, val);
    }

    public int[][] getIntervals() {
        List<int[]> answer = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer.add(new int[] {entry.getKey(), entry.getValue()});
        }

        return answer.toArray(new int[][]{});
    }

//    List<Integer> values = new LinkedList<>();
//
//    public SummaryRanges() {
//
//    }
//
//    public void addNum(int val) {
//        for (int i = 0; i < values.size(); i++) {
//            if (val < values.get(i)) {
//                values.add(i, val);
//                return;
//            }
//        }
//        values.add(val);
//    }
//
//    public int[][] getIntervals() {
//        System.out.println(values);
//        List<int[]> answer = new ArrayList<>();
//        int cur = 0;
//        int n = values.size();
//        while (cur < n) {
//            int a = values.get(cur);
//            // 有下一位且下一位连续
//            while (cur + 1 < n && values.get(cur) + 1 >= values.get(cur + 1) ) cur++;
//            answer.add(new int[]{a, values.get(cur)});
//            cur++;
//        }
//        return answer.toArray(new int[][]{});
//    }
}
