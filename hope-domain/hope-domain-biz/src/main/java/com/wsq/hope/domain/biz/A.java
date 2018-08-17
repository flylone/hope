package com.wsq.hope.domain.biz;

public class A {
    public A() {
        System.out.println("this is construction of A");
    }

    {
        System.out.println("this is construction block of A");
    }

    static {
        System.out.println("this is static construction of A");
    }
}

