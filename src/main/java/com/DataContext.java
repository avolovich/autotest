package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DataContext {

    private static ApplicationContext data;

    private DataContext() { }

    public static ApplicationContext getData() {
        if (data == null) {
            data = new AnnotationConfigApplicationContext("com.data");
        }
        return data;
    }

}
