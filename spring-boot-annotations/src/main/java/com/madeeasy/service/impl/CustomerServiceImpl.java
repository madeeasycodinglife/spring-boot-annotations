package com.madeeasy.service.impl;

import com.madeeasy.service.UserService;
import org.springframework.scheduling.annotation.Async;

public class CustomerServiceImpl implements UserService {
    @Override
    public void findAllUsers() {
        System.out.println("findAllUsers called from CustomerServiceImpl");
    }

    /**
     * <p>
     * the performTask() method in the MyService class is annotated with @Async. This indicates that the method
     * should be executed asynchronously in a separate thread,allowing it to run concurrently with the main thread.
     * This can be useful for performing tasks that may take some time to complete, such as making remote API calls,
     * executing database queries, or performing heavy computations, without blocking the main thread.
     * </p>
     * It's important to note that in order to enable async execution, you need to configure an appropriate task executor
     * in your Spring application context. By default, Spring uses a SimpleAsyncTaskExecutor, but you can customize
     * it by defining a custom TaskExecutor bean.
     * <p>
     * Using the @Async annotation allows you to leverage the benefits of asynchronous programming in your Spring application,
     * improving performance and responsiveness by executing tasks concurrently.
     * </p>
     */
    @Async
    @Override
    public void performTask() {
        System.out.println("Task started...");
        // Perform the task logic here
        System.out.println("Task completed.");
    }
}
