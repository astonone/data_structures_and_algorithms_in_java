package com.kulygin;

import com.kulygin.utils.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(11);
        System.out.println(stack.peek());
        stack.push(22);
        System.out.println(stack.peek());
        stack.push(33);
        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}