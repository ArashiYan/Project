package com.lihaoran.base;

public class ExceptionAuto {
    public static void main(String[] args) {
        int a = 1;
        int b = 0;

            System.out.println(a/b);


    }
    void Exc(int a,int b) throws ArithmeticException{
        if (b==0){
            throw new ArithmeticException();
        }
    }
}
