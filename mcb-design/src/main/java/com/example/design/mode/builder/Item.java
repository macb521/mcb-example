package com.example.design.mode.builder;

/**
 * @author chunbo.ma.o
 * @since 2023/6/26
 */
public interface Item {
    String name();

    Packing packing();

    float price();
}
