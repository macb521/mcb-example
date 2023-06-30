package com.example.design.mode.decorator;

import java.math.BigDecimal;

/**
 * @Classname BoBoMilkTea
 * @Description TODO
 * @Date 2023/4/15 11:09
 * @Created by 马春波
 */
public class BoBoMilkTea implements MilkTea{
    @Override
    public String getDescription() {
        return "波波奶茶";
    }

    @Override
    public BigDecimal cost() {
        return BigDecimal.valueOf(12);
    }
}
