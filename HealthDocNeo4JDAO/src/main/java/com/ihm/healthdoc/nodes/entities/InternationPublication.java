package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="INTERNATIONAL_PUBLICATION")
public class InternationPublication {

    @GraphId 
    private Long nodeId;
    
    private String description;
        
    private String year;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
	return "InternationPublication [nodeId=" + nodeId + ", description=" + description + ", year=" + year + "]";
    }
    
    
}
