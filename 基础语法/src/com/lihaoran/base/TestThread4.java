package com.lihaoran.base;

//多线程同时操作一个对象


public class TestThread4 implements Runnable{
    //票数
    private int ticketnums = 10;
    @Override
    public void run() {
        while (true){
            if (ticketnums<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticketnums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 ticket = new TestThread4();
        new Thread(ticket,"a").start();
        new Thread(ticket,"b").start();
        new Thread(ticket,"c").start();

    }
}
