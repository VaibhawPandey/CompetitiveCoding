package main.java.Leetcode.Chal30days.Week2;

import java.util.Stack;

public class MinStack {

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(2147483647);
        minStack.push(-2147483648);
        // minStack.push(2);
        System.out.println(minStack.getMin() +" -- " +minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    Stack<Long> stack;
    int minElement;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
          if (stack.size() == 0){
              stack.push((long) x);
              minElement = x;
          } else if (x < minElement) {
              System.out.println((long) 2*x);
              System.out.println(minElement);
              long temp = (long) 2*x - minElement;
              stack.push(temp);
              minElement = x;
          } else
              stack.push((long) x);
    }

    public void pop() {
        if (!stack.empty()) {
            long temp = stack.pop();
            if (temp < minElement)
                minElement =(int) (2*minElement - temp);
        }
    }

    public int top() {
        if (!stack.empty()) {
            long temp = stack.peek();
            if (temp < minElement)
                return minElement;
            else
                return (int) temp;
        }
        return 0;
    }

    public int getMin() {
        return minElement;
    }
}
