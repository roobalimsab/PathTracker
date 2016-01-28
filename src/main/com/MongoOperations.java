package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class MongoOperations {

    private MongoTemplate mongoTemplate;
    private LocationDetail locationDetail;
    private final Vertex vertex;
    private final Edge edge;

    @Autowired
    public MongoOperations(MongoTemplate mongoTemplate, LocationDetail locationDetail, Vertex vertex, Edge edge) {
        this.mongoTemplate = mongoTemplate;
        this.locationDetail = locationDetail;
        this.vertex = vertex;
        this.edge = edge;
    }

    public void insertDocs(String locationName, List neighbours) {
        locationDetail.setLocationName(locationName);
        locationDetail.setNeighbours(neighbours);
        mongoTemplate.save(locationDetail);

        vertex.setName(locationName);
        vertex.setId(locationName);
        Vertex source = vertex;
        mongoTemplate.save(source);

        neighbours.stream().forEach(destination -> {
            edge.setSource(source);
            Vertex destinationVertex = new Vertex();
            destinationVertex.setName((String) destination);
            destinationVertex.setId((String) destination);
            edge.setDestination(destinationVertex);
            edge.setWeight(1);
            mongoTemplate.save(edge);
        });

    }

    public void deleteAllDocs() {
        mongoTemplate.dropCollection(LocationDetail.class);
        mongoTemplate.dropCollection(Vertex.class);
        mongoTemplate.dropCollection(Edge.class);
    }

    public Vertex findOneVertex(String vertexName) {
        Query query = new Query(Criteria.where("name").is(vertexName));
        Vertex vertex = mongoTemplate.findOne(query, Vertex.class);
        return vertex;
    }

    public List<Vertex> findAllVertices() {
        List<Vertex> vertices = mongoTemplate.findAll(Vertex.class);
        return vertices;
    }

    public List<Edge> findAllEdges() {
        List<Edge> edges = mongoTemplate.findAll(Edge.class);
        return edges;
    }
}
