package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="DEGREE_DETAILS")
public class DegreeDetails {
        
    @GraphId 
    private Long nodeId;
    
    private String name;
    private String degreeSrlNumber;
    private String passoutYear;
    private String practiceDegree;
    private String shortDescription;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDegreeSrlNumber() {
        return degreeSrlNumber;
    }
    public void setDegreeSrlNumber(String degreeSrlNumber) {
        this.degreeSrlNumber = degreeSrlNumber;
    }
    public String getPassoutYear() {
        return passoutYear;
    }
    public void setPassoutYear(String passoutYear) {
        this.passoutYear = passoutYear;
    }
    public String getPracticeDegree() {
        return practiceDegree;
    }
    public void setPracticeDegree(String practiceDegree) {
        this.practiceDegree = practiceDegree;
    }
    public String getShortDescription() {
        return shortDescription;
    }
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
    @Override
    public String toString() {
	return "DegreeDetails [nodeId=" + nodeId + ", name=" + name + ", degreeSrlNumber=" + degreeSrlNumber
		+ ", passoutYear=" + passoutYear + ", practiceDegree=" + practiceDegree + ", shortDescription="
		+ shortDescription + "]";
    }
    
    
}
