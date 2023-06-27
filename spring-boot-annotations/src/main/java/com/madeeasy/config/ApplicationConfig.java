package com.madeeasy.config;

import com.madeeasy.model.ConditionalBean;
import com.madeeasy.model.MyBean;
import com.madeeasy.service.EmailService;
import com.madeeasy.service.GreetingService;
import com.madeeasy.service.UserService;
import com.madeeasy.service.impl.CustomerServiceImpl;
import com.madeeasy.service.impl.EmailServiceImpl;
import com.madeeasy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * In Spring Framework, the @Configuration annotation is used to indicate that a class is a configuration class that defines
 * one or more Spring beans. A configuration class is responsible for creating and configuring the beans in the Spring container.
 */

/**
 * the @Configuration annotation is used to indicate that a class is a configuration class, which defines the configuration for the
 * application context. It is typically used in combination with other annotations like @Bean, @ComponentScan, and @Import
 * to provide the necessary configuration for Spring applications.
 */
@Configuration // @Configuration indicates that the class has @Bean definition methods.
/**
 * classpath means that the class includes source code and resource files
 * classpath refers to "src/main/resources" where application.properties is located as it
 * contains your resource files, including the application.properties file.
 *
 * when using @PropertySource("classpath:application.properties"), it refers to the application.properties file
 * located in the target/classes directory, which is indeed part of the classpath when running the application.
 */
/**
 * In a Maven project, during the build process, the contents of the src/main/java directory are compiled into
 * class files and placed in the target/classes directory. Similarly, the files in the src/main/resources
 * directory are copied to the target/classes directory as well .
 *
 * The target/classes directory, along with any additional dependencies, forms the classpath when running the application.
 * This means that the compiled classes and the resource files in target/classes (including their package structure)
 * are accessible on the classpath.
 *============================================= ClassPath Definition  ===============================================
 * In short to know if the files are in the classpath, only see if they are in the "target/classes" directory if they are
 * present in the "target/classes" directory [after the build (up and running)] then it is said that the
 * files are in the classpath else they are not in the classpath.
 * in spring boot ::
 * ****************************
 * in the target/classes directory all the files are in the classpath ::
 * target
 * |--classes
 *    |--com
 *       |--madeeasy
 *          |--config
 *             |--ApplicationConfig
 *          |--model
 *             |--MyBean
 *          |--service
 *             |--impl
 *                |--UserServiceImpl
 *                |--CustomerServiceImpl
 *                |--EmailServiceImpl
 *             |--EmailService
 *             |--UserService
 *          |--SpringBootApplication
 *       |--application.properties
 * ****************************
 * =====================================================================================================================
 */
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    @Bean
    @Qualifier("userServiceQualifier")
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean(name = "customerServiceBean")
    public UserService customerService() {
        return new CustomerServiceImpl();
    }

    @Bean
    public EmailService emailService() {
        return new EmailServiceImpl();
    }

    @Bean
    public MyBean myBean() {
        MyBean bean = new MyBean();
        bean.setName(environment.getProperty("app.name"));
        bean.setVersion(environment.getProperty("app.version"));
        return bean;
    }

    /**
     * if GreetingService bean is created then only ConditionalBean will be created
     * else no bean will be created for class ConditionalBean.
     */
    /**
     * similarly
     * @ConditionalOnMissingBean will create a bean for class ConditionalBean
     * if the class GreetingService is not annotated with
     * @Service .
     */
    @Bean
    @ConditionalOnBean(GreetingService.class)
    public ConditionalBean conditionalBean() {
        return new ConditionalBean();
    }

    /**
     * @ConditionalOnProperty
     * @ConditionalOnResource
     * @ConditionalOnWebApplication and
     * @ConditionalOnNotWebApplication
     * @ConditionalExpression
     * @Conditional
     */
}



























