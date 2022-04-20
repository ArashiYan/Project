package com.lihaoran.Thread;
//观测线程的优先级
public class TestPriority {
    public static void main(String[] args) {
        //主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"..."+ Thread.currentThread().getPriority());
        Mypriority mypriority = new Mypriority();
        Thread thread0 = new Thread(mypriority);
        Thread thread1 = new Thread(mypriority);
        Thread thread2 = new Thread(mypriority);
        Thread thread3 = new Thread(mypriority);
        Thread thread5 = new Thread(mypriority);
        Thread thread6 = new Thread(mypriority);


        //先设置线程优先级再启动

        thread0.start();

        thread1.setPriority(1);
        thread1.start();

        thread2.setPriority(4);
        thread2.start();

        thread3.setPriority(Thread.MAX_PRIORITY);
        thread3.start();

    }
}

class Mypriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"------"+ Thread.currentThread().getPriority());
    }
}