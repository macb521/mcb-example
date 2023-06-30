package com.example.design.mode.factory.ObjectProviderFactory.annotation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FactoryType {

    FactoryPolicy type ();

    boolean enable() default true;
}
