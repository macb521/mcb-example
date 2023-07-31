package com.example.design.mode.decorator;

import java.math.BigDecimal;

/**
 * @Classname Coconut
 * @Description TODO
 * @Date 2023/4/15 11:12
 * @Created by 马春波
 */
public class Coconut implements Condiment{

    private MilkTea milkTea;

    public Coconut(MilkTea milkTea) {
        this.milkTea = milkTea;
    }

    @Override
    public String getDescription() {
        return milkTea.getDescription() + "+ 椰果";
    }

    @Override
    public BigDecimal cost() {
        return milkTea.cost().add(BigDecimal.valueOf(2.0));
    }
}
