package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="COMPLICATIONS_INFO")
public class ComplicationsInfo {

    @GraphId 
    private Long nodeId;
    
    private String description;
    
    private String year;
    
    private String surgeryProcedureDescription;

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

    public String getSurgeryProcedureDescription() {
        return surgeryProcedureDescription;
    }

    public void setSurgeryProcedureDescription(String surgeryProcedureDescription) {
        this.surgeryProcedureDescription = surgeryProcedureDescription;
    }

    @Override
    public String toString() {
	return "ComplicationsInfo [nodeId=" + nodeId + ", description=" + description + ", year=" + year
		+ ", surgeryProcedureDescription=" + surgeryProcedureDescription + "]";
    }
    
}
