import java.util.ArrayDeque;

/*
https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/ 5ms 38.3MB
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String [] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        try {
            for (String token : tokens) {
                int a,b;
                switch (token) {
                    case "+":
                        b = deque.pop();
                        a = deque.pop();
                        deque.push(a + b);
                        break;
                    case "-":
                        b = deque.pop();
                        a = deque.pop();
                        deque.push(a - b);

                        break;
                    case "*":
                        b = deque.pop();
                        a = deque.pop();
                        deque.push(a * b);
                        break;
                    case "/":
                        b = deque.pop();
                        a = deque.pop();
                        deque.push(a / b);
                        break;
                    default:
                        deque.push(Integer.parseInt(token));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return deque.pop();
    }
}