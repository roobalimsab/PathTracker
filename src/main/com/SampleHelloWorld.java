package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SampleHelloWorld {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");

        MongoOperations mongoOperations = (MongoOperations) context.getBean("mongoOperations");

        mongoOperations.deleteAllDocs();

        mongoOperations.insertDocs("cubbon park", Arrays.asList("recruitment", "techops"));
        mongoOperations.insertDocs("techops", Arrays.asList("gofigure", "pantry", "cubbon park"));
        mongoOperations.insertDocs("recruitment", Arrays.asList("pharmacy", "cubbon park"));
        mongoOperations.insertDocs("pharmacy", Arrays.asList("clicklist", "recruitment"));
        mongoOperations.insertDocs("clicklist", Arrays.asList("pharmacy", "bahmini"));
    }

}
