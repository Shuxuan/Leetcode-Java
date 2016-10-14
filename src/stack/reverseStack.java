package stack;

import java.util.Stack;

/**
 * Created by shuxuannie on 7/15/16.
 */
public class ReverseStack {

    public static void reverseOrder(Stack<Integer> s) {
        if (!s.isEmpty()) {
            int tmp = s.pop();
            reverseOrder(s);
            insert(s, tmp);
        }

    }

    public static void insert(Stack<Integer> s, int tmp) {
        if (s.isEmpty()) {
            s.push(tmp);
        } else {
            int item = s.pop();
            insert(s, tmp);
            s.push(item);
        }
    }


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        for (Integer item : stack) {
            System.out.println(item);
        }

        ReverseStack.reverseOrder(stack);
        for (Integer item : stack) {
            System.out.println(item);
        }

    }
}
