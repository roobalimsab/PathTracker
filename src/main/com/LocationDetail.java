package com;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "locationDetails")
public class LocationDetail {
    private final String locationName;
    private final List<String> neighbours;

    public LocationDetail(String locationName, List<String> neighbours) {
        this.locationName = locationName;
        this.neighbours = neighbours;
    }
}
