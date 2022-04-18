package com.lihaoran.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class c1 = Class.forName("com.lihaoran.reflection.User");

        //User user = (User) c1.newInstance();
        //System.out.println(user);

//        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//        User lihaoran = (User)constructor.newInstance("lihaoran", 001, 24);
//        System.out.println(lihaoran);

        User user3 = (User) c1.newInstance();
        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(user3, "lihai");
        System.out.println(user3.getName());

        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user4, "lll");
        System.out.println(user4.getName());


    }
}
