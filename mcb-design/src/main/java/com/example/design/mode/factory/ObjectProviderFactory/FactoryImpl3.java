package com.example.design.mode.factory.ObjectProviderFactory;

import com.example.design.mode.factory.ObjectProviderFactory.annotation.FactoryPolicy;
import com.example.design.mode.factory.ObjectProviderFactory.annotation.FactoryType;
import org.springframework.stereotype.Service;

@Service
@FactoryType(type = FactoryPolicy.TEST3)
public class FactoryImpl3 implements IFactoryInter {
    @Override
    public void test() {
        System.out.println("33333333333");
    }
}
