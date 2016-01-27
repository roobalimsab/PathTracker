package com;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "locationDetails")
public class LocationDetail {
    private String locationName;
    private List<String> neighbours;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void setNeighbours(List<String> neighbours) {
        this.neighbours = neighbours;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }
}
