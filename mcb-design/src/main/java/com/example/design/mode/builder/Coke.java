package com.example.design.mode.builder;

/**
 * @author chunbo.ma.o
 * @since 2023/6/26
 */
public class Coke extends AbstractColdDrink{
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
