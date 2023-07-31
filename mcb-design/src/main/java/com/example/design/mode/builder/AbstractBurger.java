package com.example.design.mode.builder;

/**
 * @author chunbo.ma.o
 * @since 2023/6/26
 */
public abstract class AbstractBurger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
