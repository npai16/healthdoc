package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="FACULTY_INVITATION")
public class FacultyInvitation {
    
    @GraphId 
    private Long nodeId;

    private String description;
    
    private String yearOfConference;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYearOfConference() {
        return yearOfConference;
    }

    public void setYearOfConference(String yearOfConference) {
        this.yearOfConference = yearOfConference;
    }

    @Override
    public String toString() {
	return "FacultyInvitation [nodeId=" + nodeId + ", description=" + description + ", yearOfConference="
		+ yearOfConference + "]";
    }
    
    
}
