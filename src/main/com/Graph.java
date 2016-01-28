package com;

import java.util.List;

public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertexes = vertices;
        this.edges = edges;
    }

    public List<Vertex> getVertices() {
        return vertexes;
    }

    public List<Edge> getEdges() {
        return edges;
    }



}

