package com.lihaoran.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Test08 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.lihaoran.reflection.Student2");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        Tableyan tableyan = (Tableyan) c1.getAnnotation(Tableyan.class);
        String value = tableyan.value();
        System.out.println(value);


        Field name = c1.getDeclaredField("id");
        Fieldkuang annotation = name.getAnnotation(Fieldkuang.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }
}

@Tableyan("db_student")
class Student2 {
    @Fieldkuang(columnName = "db_name",type = "String",length = 3)
    private String name;
    @Fieldkuang(columnName = "db_id",type = "int",length = 10)
    private int id;
    @Fieldkuang(columnName = "db_id",type = "int",length = 10)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student2() {
    }

    Student2(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}




@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tableyan{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldkuang{
    String columnName();
    String type();
    int length();
}