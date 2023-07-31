package com.example.design.mode.decorator;

import java.math.BigDecimal;

/**
 * @Classname MilkTea
 * @Description TODO
 * @Date 2023/4/15 11:07
 * @Created by 马春波
 */
public interface MilkTea {


    //奶茶名称
    String getDescription();

    //奶茶价格
    BigDecimal cost ();
}
