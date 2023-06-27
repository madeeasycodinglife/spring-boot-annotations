package com.madeeasy.component;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.stereotype.Component;

@Component
/**
 * as "com.madeeasy.model.ExampleClassNotPresent" does not exists then a bean will be created for class
 * CustomConditionalOnMissingClass.
 */
@ConditionalOnMissingClass("com.madeeasy.model.ExampleClassNotPresent")
public class CustomConditionalOnMissingClass {
    public CustomConditionalOnMissingClass() {
        System.out.println("CustomConditionalOnMissingClass is being called");
    }
}
