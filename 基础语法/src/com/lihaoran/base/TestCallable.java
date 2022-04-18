package com.lihaoran.base;

import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {
    //票数
    private int ticketnums = 10;
    @Override
    public Boolean call() {
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
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable ts1 = new TestCallable();
        TestCallable ts2 = new TestCallable();
        TestCallable ts3 = new TestCallable();
        ExecutorService ser = Executors.newFixedThreadPool(3);

        Future<Boolean> t1 = ser.submit(ts1);
        Future<Boolean> t2 = ser.submit(ts2);
        Future<Boolean> t3 = ser.submit(ts3);

        boolean r1 = t1.get();
        boolean r2 = t2.get();
        boolean r3 = t3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        ser.shutdownNow();

    }

}
