package com.lihaoran.base;

public class TestThread implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("aaa");
        }
    }

    public static void main(String[] args) {
        TestThread th = new TestThread();
        new Thread(th).start();
        for (int i = 0; i < 10; i++) {
            System.out.println("bbb");
        }
    }
}
