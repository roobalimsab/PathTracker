package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;

public class MongoOperations {

    private MongoTemplate mongoTemplate;
    private LocationDetail locationDetail;

    @Autowired
    public MongoOperations(MongoTemplate mongoTemplate, LocationDetail locationDetail) {
        this.mongoTemplate = mongoTemplate;
        this.locationDetail = locationDetail;
    }

    public void insertDocs() {
        locationDetail.setLocationName("cubbon park");
        locationDetail.setNeighbours(Arrays.asList("recruitment", "techops"));
        mongoTemplate.save(locationDetail);
    }

}
