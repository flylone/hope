package com.wsq.hope.domain.biz;

public class RunnableDemo {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
