package com.lihaoran.lock;

//生产者消费者问题，利用缓冲区解决：管程法
public class TestPC {
    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();

        new Producer(synContainer).start();
        new Consumer(synContainer).start();
    }
}

class Producer extends Thread{
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了第"+ i +"只鸡");
        }
    }
}

class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("消费了第"+container.pop().id + "只鸡");
        }
    }
}

class Chicken{
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}



//缓冲区
class SynContainer{
    //容器
    Chicken[] chickens = new Chicken[10];
    int count =0;

    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //容器满了需要消费
        if (count == chickens.length){
            //通知消费者消费，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //没满就放入产品
        chickens[count] = chicken;
        count++;

        //通知消费
        this.notifyAll();
    }

    //消费者消费产品
    public synchronized Chicken pop(){
        //判断能否消费
        if (count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果可以消费
        count--;
        Chicken chicken = chickens[count];

        this.notifyAll();
        return chicken;
    }


}

