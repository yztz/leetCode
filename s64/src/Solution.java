import java.util.ArrayList;
import java.util.List;

/* https://leetcode-cn.com/problems/text-justification/ 模拟 */
public class Solution {

    public static void main(String[] args) {
        String pattern = String.format("%%-%ds", 16);
        System.out.println(pattern);
        System.out.printf(pattern, "acknowledgement");
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        int curr = 0;
        String pattern = String.format("%%-%ds", maxWidth);
        List<String> line = new ArrayList<>();
        List<String> answer = new ArrayList<>();
        int width = 0;
        while (curr < n) {
            if (width + line.size() + words[curr].length() <= maxWidth) {
                line.add(words[curr]);
                width += words[curr].length();
                curr++;
            } else {
                if (line.size() == 1) {
                    answer.add(String.format(pattern, line.get(0)));
                } else {
                    StringBuilder sb = new StringBuilder();
                    int spacePerWord = (maxWidth - width) / (line.size() - 1);
                    int additionalSpace = (maxWidth - width) % (line.size() - 1);
                    int i = 0;
                    for (; i < line.size() - 1; i++) {
                        sb.append(line.get(i));
                        for (int j = 0; j < spacePerWord; j++) sb.append(' ');
                        if (i < additionalSpace) sb.append(' ');
                    }
                    answer.add(sb.append(line.get(i)).toString());
                }

                line.clear();
                width = 0;
            }
        }
        if (width != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (; i < line.size() - 1; i++) {
                sb.append(line.get(i));
                sb.append(' ');
            }
            sb.append(line.get(i));
            answer.add(String.format(pattern, sb));
        }
        return answer;
    }
}


