package com.madeeasy;

import com.madeeasy.component.ConditionalComponent;
import com.madeeasy.model.MyBean;
import com.madeeasy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import package1.Componet1;
import package2.Componet2;

@SpringBootApplication
@EnableAsync
/**
 * @ComponentScan is used with "@Component"
 */
@ComponentScan(basePackages = {"com.madeeasy", "package1", "package2"})
public class SpringBootAnnotationsApplication implements CommandLineRunner {

    @Autowired
//    @Qualifier("customerServiceBean")
//    @Qualifier("userServiceQualifier")
    @Qualifier("employeeService") // "employeeServiceImpl" this is default value i.e. camelCase used by spring
    private UserService user; // this "user" is used when there is one bean if more than one bean then use @Qualifier("")

    @Autowired
    private MyBean myBean;

    @Autowired
    private Componet1 componet1;
    @Autowired
    private Componet2 componet2;

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(SpringBootAnnotationsApplication.class, args);
        if (context.containsBean("conditionalComponent")) {
            ConditionalComponent conditionalComponent = context.getBean(ConditionalComponent.class);
            conditionalComponent.doSomething();
        } else {
            System.out.println("ConditionalComponent not found");
        }
    }

    @Override
    public void run(String... args) throws Exception {
        user.findAllUsers();
        System.out.println("MyBean " + myBean);
        myBean.doSomething();
        user.performTask();
        componet1.doSomething();
        componet2.doSomething();
    }
}
