package com.lihaoran.syn;

//不安全的买票
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "我").start();
        new Thread(buyTicket, "黄牛").start();
        new Thread(buyTicket, "你们").start();
    }
}

class BuyTicket implements Runnable{

    private int ticketNums = 10;
    boolean flag = true;//外部停止方式
    @Override
    public void run() {
        //买票
        while (flag) {
            buy();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized 同步方法，锁的是this
    private synchronized void buy(){
        if (ticketNums<=0){
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}