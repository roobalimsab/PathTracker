package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleHelloWorld {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");

        MongoOperations mongoOperations = (MongoOperations) context.getBean("mongoOperations");

        mongoOperations.insertDocs();
    }

}
