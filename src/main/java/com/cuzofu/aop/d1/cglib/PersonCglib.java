package com.cuzofu.aop.d1.cglib;

public class PersonCglib {
    public void sayHi() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!!");
    }

    public void sayBye() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!!");
    }
}
