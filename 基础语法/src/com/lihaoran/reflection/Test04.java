package com.lihaoran.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test04 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.lihaoran.reflection.User");

        System.out.println(c1.getName());
        System.out.println(c1.getSimpleName());

        Field[] fields = c1.getFields();
        fields = c1.getDeclaredFields();
        for (Field field:fields
             ) {
            System.out.println(field);
        }

        Method[] methods = c1.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("===============");
        methods = c1.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

    }
}
