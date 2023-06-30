package com.example.design.mode.adapter;

/**
 * @author chunbo.ma.o
 */
public abstract class AbstractWrapper implements Sourceable {

    @Override
    public void method1() {
        System.out.println("abstract 1");
    }

    @Override
    public void method2() {
        System.out.println("abstract 2");
    }
}
