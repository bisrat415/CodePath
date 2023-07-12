// This is a solution for Q.155(Min Stack) from Leetcode

import java.util.Stack;

public class MinStack {
     Stack<Integer> mainStack;
    Stack<Integer> minValsStack;

    public MinStack() {
        mainStack = new Stack<>();
        minValsStack = new Stack<>();
    }
    
    public void push(int val) {
        mainStack.push(val);
        if (!minValsStack.isEmpty()) {
            if (minValsStack.peek() < val) {
                minValsStack.push(minValsStack.peek());
            } else {
                minValsStack.push(val);
            }
        } else {
            minValsStack.push(val);
        }

    }
    
    public void pop() {
        mainStack.pop();
        minValsStack.pop();
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minValsStack.peek();
    }

    public static void main(String[] args) {
        MinStack minstack = new MinStack();
        minstack.push(-2);
        minstack.push(0);
        minstack.push(-3);
        System.out.println(minstack.getMin()); // return -3
        minstack.pop();
        System.out.println(minstack.top());    // return 0
        System.out.println(minstack.getMin()); // return -2
    }

    // All the functions take O(1) time so n operations will take O(n) time
}
