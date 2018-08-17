package com.wsq.hope.domain.biz;

public class B extends A {
    public B() {
        System.out.println("this is construction of B");
    }

    {
        System.out.println("this is construction block of B");
    }

    static {
        System.out.println("this is static construction of B");
    }

    public static void main(String[] args) {
        B b = new B();
    }
}

