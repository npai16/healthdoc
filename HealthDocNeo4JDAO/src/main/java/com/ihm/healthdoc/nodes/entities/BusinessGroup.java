package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;
import java.util.List;


@NodeEntity(label="BUSINESS_GROUP")
public class BusinessGroup {
    
    @GraphId 
    private Long nodeId;
    
    @Property(name="code")
    private String code;
    
    @Property(name="name")
    private String name;
    
    @Property(name="address")
    private Address address;
    
    @Property(name="website")
    private String website;
    
    @Property(name="email")    
    private String email;
    
    @Property(name="contactperson")    
    private String contactPerson;    
    
    @Property(name="status")
    private String status;
    
    @Relationship(type = "IS_HAVING", direction= Relationship.OUTGOING)
    private List<Hospital> hospitals;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(List<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    @Override
    public String toString() {
	return "BusinessGroup [nodeId=" + nodeId + ", code=" + code + ", name=" + name + ", address=" + address
		+ ", website=" + website + ", email=" + email + ", contactPerson=" + contactPerson + ", status="
		+ status + ", hospitals=" + hospitals + "]";
    }
    
}