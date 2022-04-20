package com.lihaoran.Thread;

//测试join方法  约等于插队
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        //主线程
        for (int i = 0; i < 300; i++) {
            if (i == 200){
                thread.join();
            }
            System.out.println("main" + i);
        }
    }
}
