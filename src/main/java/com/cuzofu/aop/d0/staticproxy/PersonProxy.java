package com.cuzofu.aop.d0.staticproxy;

import com.cuzofu.aop.d0.IPerson;
import com.cuzofu.aop.d0.Person;

import java.util.logging.Logger;

public class PersonProxy {
    private IPerson iPerson;

    private final static Logger logger = Logger.getLogger("PersonProxy");

    public PersonProxy(IPerson iPerson) {
        this.iPerson = iPerson;
    }

    private void doSomething() {
        logger.info("Before Proxy!");
        iPerson.doSomething();
        logger.info("After Proxy!");
    }

    public static void main(String[] args) {
        PersonProxy personProxy = new PersonProxy(new Person());
        personProxy.doSomething();
    }
}
