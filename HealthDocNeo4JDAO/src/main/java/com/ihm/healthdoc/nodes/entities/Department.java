package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

@NodeEntity(label="DEPARTMENT")
public class Department {

    @GraphId 
    private Long nodeId;
	
    @Property(name="id")
    private String id;
	
    @Property(name="name")
    private String name;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
	return "Department [nodeId=" + nodeId + ", id=" + id + ", name=" + name + "]";
    }    
}
