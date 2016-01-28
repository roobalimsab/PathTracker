package com;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShortestPath {

    private MongoOperations mongoOperations;

    @Autowired
    public ShortestPath(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public List<String> trackFromSourceToDestination(String source, String destination) {
        LocationDetail foundLocationDetail = mongoOperations.findOne(source);
        return foundLocationDetail.getNeighbours();
    }
}
