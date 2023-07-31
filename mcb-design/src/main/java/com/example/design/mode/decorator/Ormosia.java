package com.example.design.mode.decorator;

import java.math.BigDecimal;

/**
 * @Classname ormosia
 * @Description TODO
 * @Date 2023/4/15 11:15
 * @Created by 马春波
 */
public class Ormosia implements Condiment{
    private MilkTea milkTea;

    public Ormosia(MilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public String getDescription() {
        return milkTea.getDescription() + "+ 红豆";
    }

    @Override
    public BigDecimal cost() {
        return milkTea.cost().add(BigDecimal.valueOf(3.0));
    }
}
