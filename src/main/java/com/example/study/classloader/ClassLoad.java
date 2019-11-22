package com.example.study.classloader;

/**
 * @author: caoyangfan
 * @create: 2019-11-21 10:38
 **/
public class ClassLoad {

    public static void main(String[] args) {
        //Parent p = new Parent();
        //Sub sub = new Sub();
        //sub.print();

    }
}

class Parent {
    public static Integer A = 1;
    static {
        System.out.println("2");
    }

    Parent(){
        System.out.println("Parent init");
    }

    public void print(){
        System.out.println("Parent print method");
    }
}


class Sub extends Parent{
    public static Integer A = 3;
    static {
        System.out.println("4");
    }

    Sub(){
        System.out.println("Sub init");
    }

    @Override
    public void print(){
        System.out.println("Sub print method");
    }
}