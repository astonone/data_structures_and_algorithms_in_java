package com.kulygin;

import com.kulygin.utils.PriorityQ;

public class Main {
    public static void main(String[] args) {
        PriorityQ thePQ = new PriorityQ();
        thePQ.insert(30);
        thePQ.insert(50);
        thePQ.insert(10);
        thePQ.insert(40);
        thePQ.insert(20);

        thePQ.display();

        System.out.println(thePQ.remove());
        System.out.println(thePQ.remove());

        thePQ.display();
    }
}