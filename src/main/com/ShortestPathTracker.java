package com;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class ShortestPathTracker {

    private MongoOperations mongoOperations;

    @Autowired
    public ShortestPathTracker(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public LinkedList<Vertex> trackFromSourceToDestination(String source, String destination) {
        Vertex sourceVertex = mongoOperations.findOneVertex(source);
        Vertex destinationVertex = mongoOperations.findOneVertex(destination);

        List<Vertex> allVertices = mongoOperations.findAllVertices();
        List<Edge> allEdges = mongoOperations.findAllEdges();

        Graph graph = new Graph(allVertices, allEdges);

        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm(graph);

        dijkstraAlgorithm.execute(sourceVertex);

        LinkedList<Vertex> path = dijkstraAlgorithm.getPath(destinationVertex);

        return path;
    }
}
