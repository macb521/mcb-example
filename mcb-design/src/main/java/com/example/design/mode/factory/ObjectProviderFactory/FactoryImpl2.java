package com.example.design.mode.factory.ObjectProviderFactory;

import com.example.design.mode.factory.ObjectProviderFactory.annotation.FactoryPolicy;
import com.example.design.mode.factory.ObjectProviderFactory.annotation.FactoryType;
import org.springframework.stereotype.Service;

@Service
@FactoryType(type = FactoryPolicy.TEST2)
public class FactoryImpl2 implements IFactoryInter {
    @Override
    public void test() {
        System.out.println("22222222222222");
    }
}
