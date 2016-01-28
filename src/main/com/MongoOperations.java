package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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

    public LocationDetail findOne(String source) {
        Query query = new Query(Criteria.where("locationName").is(source));
        LocationDetail sourceLocationDetail = mongoTemplate.findOne(query, LocationDetail.class);
        return sourceLocationDetail;
    }
}
