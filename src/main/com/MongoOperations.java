package com;

import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;

public class MongoOperations {

    public void insertDocs(MongoTemplate mongoTemplate) {
        LocationDetail locationDetail = new LocationDetail("cubbon park", Arrays.asList("recruitment", "techops"));
        mongoTemplate.save(locationDetail);
    }

}
