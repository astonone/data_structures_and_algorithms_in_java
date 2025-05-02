package com.kulygin;

import com.kulygin.utils.Stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(20);
        stack.push(40);
        stack.push(60);
        stack.push(80);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
