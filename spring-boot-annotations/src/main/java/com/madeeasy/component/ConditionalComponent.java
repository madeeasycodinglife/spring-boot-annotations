package com.madeeasy.component;

import com.madeeasy.model.ExampleClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

@Component
/**
 * if "com.madeeasy.model.ExampleClass" is present then a bean will be created for class
 * ConditionalComponent else no bean will be created .
 */
@ConditionalOnClass(name = "com.madeeasy.model.ExampleClass")
public class ConditionalComponent {
    public void doSomething() {
        System.out.println("Doing something in ConditionalComponent...");
        ExampleClass exampleClass = new ExampleClass();
        exampleClass.printMessage();
    }
}
