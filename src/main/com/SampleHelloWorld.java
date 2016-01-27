package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

public class SampleHelloWorld {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
        Hello hello = (Hello) context.getBean("hello");
        hello.sayHello();

        MongoTemplate mongoTemplate = (MongoTemplate) context.getBean("mongoTemplate");
        MongoOperations mongoOperations = (MongoOperations) context.getBean("mongoOperations");

        mongoOperations.insertDocs(mongoTemplate);
    }

}
