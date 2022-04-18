package com.lihaoran.base;

public class Race implements Runnable {
    private static String winner;

    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("兔子")){
            try {
                Thread.sleep(40);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i <= 100; i++) {
            boolean flag = gameOver(i);
            if(flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "米");
            if (Thread.currentThread().getName().equals("兔子")){
                i++;
            }
        }
    }
    private boolean gameOver(int step){
        if (winner != null){
            return true;
        }
        if (step>=100){
            winner = Thread.currentThread().getName();
            System.out.println(winner+"胜利");
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Race race = new Race();
        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}