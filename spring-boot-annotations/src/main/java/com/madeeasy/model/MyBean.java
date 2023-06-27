package com.madeeasy.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MyBean {

    public MyBean() {
        System.out.println("MyBean constructor is called");
    }

    private String name;
    private String version;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * output will be look like ::
     * <p>
     * MyBean constructor is called
     * Initializing bean...
     * Doing something...
     * Destroying bean...
     * <p>
     * This output confirms that the init() method is called after the bean is constructed (@PostConstruct),
     * the doSomething() method is executed, and the cleanup() method is called before the bean is destroyed (@PreDestroy).
     */
    @PostConstruct
    public void init() {
        System.out.println("Initializing bean...");
        // Perform initialization logic here
    }

    public void doSomething() {
        System.out.println("Doing something...");
        // Perform business logic here
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("Destroying bean...");
        // Perform cleanup logic here
    }

    @Override
    public String toString() {
        return "MyBean [name=" + name + ", version=" + version + "]";
    }
}
