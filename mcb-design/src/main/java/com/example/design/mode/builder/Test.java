package com.example.design.mode.builder;

/**
 * @author chunbo.ma.o
 * @since 2023/6/26
 */
public class Test {

    public static void main(String[] args) {
        Meal vegMeal = Meal.buider()
                .addBuider(new VegBurger())
                .addBuider(new Coke())
                .build();

        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = Meal.buider()
                .addBuider(new ChickenBurger())
                .addBuider(new Pepsi())
                .build();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());

    }
}
