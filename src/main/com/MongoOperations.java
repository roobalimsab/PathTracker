package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public class MongoOperations {

    private MongoTemplate mongoTemplate;
    private LocationDetail locationDetail;

    @Autowired
    public MongoOperations(MongoTemplate mongoTemplate, LocationDetail locationDetail) {
        this.mongoTemplate = mongoTemplate;
        this.locationDetail = locationDetail;
    }

    public void insertDocs(String locationName, List neighbours) {
        locationDetail.setLocationName(locationName);
        locationDetail.setNeighbours(neighbours);
        mongoTemplate.save(locationDetail);
    }

    public void deleteAllDocs() {
        mongoTemplate.dropCollection(LocationDetail.class);
    }
}
