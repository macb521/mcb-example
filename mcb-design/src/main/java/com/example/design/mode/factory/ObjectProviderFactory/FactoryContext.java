package com.example.design.mode.factory.ObjectProviderFactory;

import com.example.design.mode.factory.ObjectProviderFactory.annotation.FactoryPolicy;
import com.example.design.mode.factory.ObjectProviderFactory.annotation.FactoryType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class FactoryContext {

    Map<FactoryPolicy, IFactoryInter> register = new ConcurrentHashMap<>();

    @Setter
    @Getter
    ObjectProvider<IFactoryInter[]> builderStrategies;

    public FactoryContext(ObjectProvider<IFactoryInter[]> builderStrategies) {

        this.builderStrategies = builderStrategies;
        this.builderStrategies.ifAvailable(defineTypeBuilderStrategies -> {
            Arrays.stream(defineTypeBuilderStrategies).forEach(defineTypeStrategy  -> {
                FactoryType strategy = AnnotationUtils.findAnnotation(defineTypeStrategy.getClass(), FactoryType.class);
                if (strategy != null && strategy.enable()) {
                    register.put(strategy.type(), defineTypeStrategy);
                }
            });
        });
    }

    public  IFactoryInter getStrategy(FactoryPolicy type){
        return  register.get(type);
    }
}
