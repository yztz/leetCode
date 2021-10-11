import java.util.*;

public class Solution {
    String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        List<String> answer = new LinkedList<>();
        String numStr = num + "";
        int n = numStr.length();
        int i = 0;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int cur = Integer.parseInt(numStr.substring(Math.max(n - i - 3, 0), n - i));
            if (cur == 0) {
                i += 3;
                continue;
            }
            int hundreds = cur / 100;
            int rest = cur % 100;
            if (hundreds != 0) {
                sb.append(singles[hundreds]).append(" Hundred ");
            }
            if (rest < 10) {
                if (rest != 0) sb.append(singles[rest]).append(" ");
            } else if (rest < 20) {
                sb.append(teens[rest - 10]).append(" ");
            } else {
                sb.append(tens[rest / 10]).append(" ");
                if (rest % 10 != 0) {
                    sb.append(singles[rest % 10]).append(" ");
                }
            }
            if (i / 3 != 0) sb.append(thousands[i / 3]).append(" ");
            answer.add(0, sb.toString().trim());
            i += 3;
        }

        return String.join(" ", answer);
    }

}
