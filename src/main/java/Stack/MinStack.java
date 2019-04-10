package main.java.Stack;

import java.util.Objects;
import java.util.Stack;

class MinStack {

    Stack<Integer> list, minList;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        list = new Stack<>();
        minList = new Stack<>();
    }

    public void push(int x) {
        list.add(x);

        if (minList.isEmpty()) {
            minList.push(x);
        } else {
            if (x <= minList.peek()) {
                minList.push(x);
            }
        }
    }

    public void pop() {
        if (Objects.equals(list.peek(), minList.peek())) {
            minList.pop();
        }
        list.pop();
    }

    public int top() {
        return list.peek();
    }

    public int getMin() {
        return minList.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-1000);
        obj.push(-500);
        obj.push(-300);
        obj.pop();
        int params1 = obj.getMin();
        obj.pop();
        int param_4 = obj.getMin();
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */