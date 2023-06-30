package com.example.design.mode.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chunbo.ma.o
 * @since 2023/6/26
 */
public class Meal {
    private final List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }

    public static MealBuider buider (){
        return new MealBuider();
    }

    public static class MealBuider {
        private final Meal meal = new Meal();


        public MealBuider addBuider(Item item) {
            meal.addItem(item);
            return this;
        }

        public Meal build() {
            return meal;
        }
    }


}
