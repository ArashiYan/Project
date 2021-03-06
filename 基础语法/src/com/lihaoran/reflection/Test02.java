package com.lihaoran.reflection;

public class Test02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);

        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        Class c2 = Class.forName("com.lihaoran.reflection.Student");
        System.out.println(c2.hashCode());

        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }
}

class Person{
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "老师";
    }
}