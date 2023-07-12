import java.util.*;
public class ImplementQueueWithStack {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop()); // should print 1
        queue.push(4);
        queue.push(5);
        queue.push(6);
         System.out.println(queue.peek()); // should print 2
    }
}

class MyQueue {
    Stack<Integer> normal;
    Stack<Integer> queue;
    int front = 0;

    public MyQueue() {
        normal = new Stack<>();
        queue = new Stack<>();
    }
    
    public void push(int x) {
        if (normal.isEmpty()) {
            front = x;
        }
        normal.push(x);
        // Time Complexity: O(1)
    }
    
    public int pop() {
        if (!queue.isEmpty()) {
            return queue.pop();
        }
        while (!normal.isEmpty()) {
            queue.push(normal.pop());
        }
        return queue.pop();
        // Let n be the total number of elements in both stacks
        // Time Complexity: amortized is O(1) and worst-case (when queue is empty) is O(n)
    }
    
    public int peek() {
        if (queue.isEmpty()) {
            return front;
        }
        return queue.peek();
        // Time complexity: O(1) - the front of the queue is either the variable, front (when the second stack is empty) or the top of the second stack, queue
    }
    
    public boolean empty() {
        return normal.isEmpty() && queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
