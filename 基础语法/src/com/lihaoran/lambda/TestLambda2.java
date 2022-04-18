package com.lihaoran.lambda;

public class TestLambda2 {

    public static void main(String[] args) {
        //前提是接口为函数式接口 就是只有一个方法
        ILove lo = (int a)->{
            System.out.println("I love you "+a);
        };

        //可以去掉int 去掉() 只有一行可以去掉{}
        //多个参数也可以去掉参数类型
        lo = a->System.out.println("I love you "+a);


        lo.love(3);
    }
}

interface ILove{
    void love(int a);
}

