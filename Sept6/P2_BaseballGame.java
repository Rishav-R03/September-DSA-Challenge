import java.util.Stack;

public class P2_BaseballGame {

    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String s : operations) {
            if (s.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
            } else if (s.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (s.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}
