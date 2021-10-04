public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String raw = s.replaceAll("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();
        int len = raw.length();
        int idx = len % k;
        if (idx > 0) sb.append(raw, 0, idx);
        while (idx < len) {
            if (idx > 0) sb.append('-');
            sb.append(raw, idx, idx + k);
            idx += k;
        }

        return sb.toString();
    }
}
