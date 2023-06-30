package com.example.design.mode.decorator;

import java.math.BigDecimal;

/**
 * @Classname Yuni
 * @Description TODO
 * @Date 2023/4/15 11:10
 * @Created by 马春波
 */
public class Yuni implements MilkTea{
    @Override
    public String getDescription() {
        return "芋泥奶茶";
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(14);
    }
}
