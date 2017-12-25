package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="ADDRESS")
public class Address {

    @GraphId 
    private Long nodeId;
    
    private String registeredOfficeAddress;
    
    private String city;
    
    private String state;
    
    private String pin;
    
    private String phone;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getRegisteredOfficeAddress() {
        return registeredOfficeAddress;
    }

    public void setRegisteredOfficeAddress(String registeredOfficeAddress) {
        this.registeredOfficeAddress = registeredOfficeAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
	return "Address [nodeId=" + nodeId + ", registeredOfficeAddress=" + registeredOfficeAddress + ", city=" + city
		+ ", state=" + state + ", pin=" + pin + ", phone=" + phone + "]";
    }  
   
}