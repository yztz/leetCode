import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // O(NL)因为计算哈希需要O(L)的复杂度
//    public List<String> findRepeatedDnaSequences(String s) {
//        Map<String, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length() - 9; i++) {
//            String ss = s.substring(i, i + 10);
//            map.put(ss, map.getOrDefault(ss, 0) + 1);
//        }
//        System.out.println(map);
//
//        List<String> answers = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            if (entry.getValue() > 1) answers.add(entry.getKey());
//        }
//
//        return answers;
//    }
    // 使用位操作来节省哈希计算的时间
    Map<Character, Integer> bin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};
    public List<String> findRepeatedDnaSequences(String s) {
        final int L = 10;
        Map<Integer, Integer> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        int x = 0;
        for (int i = 0; i < L - 1; i++) {
            x = x << 2 | bin.get(s.charAt(i));
        }
        for (int i = 0; i < s.length() - L + 1; i++) {
            x = (x << 2) & ((1 << 2 * L) - 1) | bin.get(s.charAt(i + L - 1));
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) == 2) {
                answer.add(s.substring(i, i + L));
            }
        }

        return answer;
    }
}
