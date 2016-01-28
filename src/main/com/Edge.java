package com;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "edges")
public class Edge  {
    private Vertex source;
    private Vertex destination;
    private int weight;

    public Vertex getDestination() {
        return destination;
    }

    public Vertex getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
