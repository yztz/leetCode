
/* https://leetcode-cn.com/problems/compare-version-numbers/ 1ms */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int v1N= v1.length;
        int v2N= v2.length;

        while (i < v1N && i < v2N) {
            int delta = Integer.parseInt(v1[i]) - Integer.parseInt(v2[i]);
            if (delta != 0) return delta / Math.abs(delta);
            i++;
        }
        while (i < v2N) if (Integer.parseInt(v2[i++]) > 0) return -1;
        while (i < v1N) if (Integer.parseInt(v1[i++]) > 0) return 1;
        return 0;
    }
}
