package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");

        MongoOperations mongoOperations = (MongoOperations) context.getBean("mongoOperations");

        mongoOperations.deleteAllDocs();

        mongoOperations.insertDocs("cubbon park", Arrays.asList("recruitment", "techops"));
        mongoOperations.insertDocs("techops", Arrays.asList("gofigure", "cubbon park", "pantry"));
        mongoOperations.insertDocs("recruitment", Arrays.asList("pharmacy", "cubbon park"));
        mongoOperations.insertDocs("pharmacy", Arrays.asList("clicklist", "recruitment"));
        mongoOperations.insertDocs("clicklist", Arrays.asList("pharmacy"));
        mongoOperations.insertDocs("gofigure", Arrays.asList("pantry", "techops"));
        mongoOperations.insertDocs("pantry", Arrays.asList("techops", "gofigure"));

        ShortestPathTracker shortestPathTracker = (ShortestPathTracker) context.getBean("shortestPathTracker");

        LinkedList<Vertex> path = shortestPathTracker.trackFromSourceToDestination("clicklist", "pantry");

        path.stream().forEach(location -> System.out.println(location.getName()));
    }

}
