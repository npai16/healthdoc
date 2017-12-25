package com.ihm.healthdoc.nodes.entities;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity(label="HOSPITAL")
public class Hospital {
    
    @GraphId 
    private Long nodeId;
	
    @Property(name="branchCode")
    private String branchCode;

    @Property(name="name")
    private String name;
    
    @Property(name="location")
    private String location;

    @Relationship(type = "IS_PART_OF", direction= Relationship.OUTGOING)
    private BusinessGroup businessGroup;
    
    @Relationship(type = "IS_HAVING", direction= Relationship.OUTGOING)
    private List<Department> departments;
    
    @Property(name="id")
    private String id;
    
    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
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
    
    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public BusinessGroup getBusinessGroup() {
        return businessGroup;
    }

    public void setBusinessGroup(BusinessGroup businessGroup) {
        this.businessGroup = businessGroup;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
	return "Hospital [nodeId=" + nodeId + ", branchCode=" + branchCode + ", name=" + name + ", location=" + location
		+ ", businessGroup=" + businessGroup + ", departments=" + departments + ", id=" + id + "]";
    }

    
}
