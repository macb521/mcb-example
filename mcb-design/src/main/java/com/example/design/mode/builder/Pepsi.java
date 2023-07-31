package com.example.design.mode.builder;

/**
 * @author chunbo.ma.o
 * @since 2023/6/26
 */
public class Pepsi extends AbstractColdDrink{
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
