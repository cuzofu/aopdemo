package com.cuzofu.aop.d1.jdk;

import com.cuzofu.aop.d1.service.Speakable;

public class PersonJdk implements Speakable {
    @Override
    public void sayHi() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!!");
    }

    @Override
    public void sayBye() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!!");
    }
}
