package com.lihaoran.base;

public class Exception {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        try{
            System.out.println(a/b);
        }catch (ArithmeticException e){
            System.out.println("捕获到了异常");
        }finally {
            System.out.println("finally");
        }

    }
}
