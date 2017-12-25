package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="EDUCATION_DETAILS")
public class EducationDetails {

    @GraphId 
    private Long nodeId;
    
    private String educationDetails;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getEducationDetails() {
        return educationDetails;
    }

    public void setEducationDetails(String educationDetails) {
        this.educationDetails = educationDetails;
    }

    @Override
    public String toString() {
	return "EducationDetails [nodeId=" + nodeId + ", educationDetails=" + educationDetails + "]";
    }
    
    
}
