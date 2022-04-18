package com.lihaoran.reflection;

public class Test01 extends Object{
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.lihaoran.reflection.User");
        System.out.println(c1);
        Class c2 = Class.forName("com.lihaoran.reflection.User");
        Class c3 = Class.forName("com.lihaoran.reflection.User");
        Class c4 = Class.forName("com.lihaoran.reflection.User");
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
        System.out.println(c4.hashCode());


    }
}
class User{
    private String name;
    private  int id;
    private int age;

    public User() {
    }

    public User(int id, int age) {
        this.id = id;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}
