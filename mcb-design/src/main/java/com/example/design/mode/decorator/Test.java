package com.example.design.mode.decorator;

/**
 * @Classname Test
 * @Description TODO
 * @Date 2023/4/15 11:17
 * @Created by 马春波
 */
public class Test {
    public static void main(String[] args) {
        MilkTea boBoMilkTea = new BoBoMilkTea();
        boBoMilkTea = new Coconut(boBoMilkTea);

        System.out.println("饮料名称：" + boBoMilkTea.getDescription() + "\n" + "饮料价格：" + boBoMilkTea.cost());


        MilkTea yuni = new Yuni();
        yuni = new Coconut(yuni);
        yuni = new Ormosia(yuni);

        System.out.println("饮料名称：" + yuni.getDescription() + "\n" + "饮料价格：" + yuni.cost());
    }
}
