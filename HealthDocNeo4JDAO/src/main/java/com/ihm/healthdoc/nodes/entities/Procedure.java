package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label="PROCEDURE")
public class Procedure {
    
    @GraphId
    private Long nodeId;

    @Property(name="code")
    private String code;

    @Property(name="name")
    private String name;
    
    @Property(name="location")
    private String location;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getLocation() {
	return location; 
    }

    public void setLocation(String location) {
	this.location = location;
    }

    @Override
    public String toString() {
	return "Procedure [nodeId=" + nodeId + ", code=" + code + ", name=" + name + "]";
    }      
}