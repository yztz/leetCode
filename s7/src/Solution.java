public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int total = 0;

        int[] counter = new int[len + 1];   // 加1是为了和论文总数一致

        for (int i = 0; i < len; i++) {
            if (citations[i] >= len) {
                counter[len]++;
            } else {
                counter[citations[i]]++;
            }
        }

        for (int i = len; i >= 0; i--) {
            total += counter[i];
            if (total >= i) return i;

        }


        return 0;
    }
}
