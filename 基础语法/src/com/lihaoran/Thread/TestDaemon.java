package com.lihaoran.Thread;

//测试守护线程
//虚拟机不会等守护线程结束
public class TestDaemon {
    public static void main(String[] args) {
        You you = new You();
        God god = new God();

        Thread thread = new Thread(god);
        thread.setDaemon(true); //默认false表示是用户线程，正常的线程都是用户线程

        thread.start();//上帝启动

        new Thread(you).start();

    }
}


class God implements Runnable{

    @Override
    public void run() {
        while (true) {
            System.out.println("上帝保佑着你");
        }
    }
}





class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("一生开心");
        }
        System.out.println("======美好世界，再见======");
    }
}
