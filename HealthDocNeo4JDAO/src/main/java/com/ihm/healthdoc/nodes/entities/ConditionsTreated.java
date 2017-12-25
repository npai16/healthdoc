package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity(label="CONDITIONS_TREATED")
public class ConditionsTreated {
    
    @GraphId 
    private Long nodeId;
    
    private String conditions;

    public Long getNodeId() {
        return nodeId;
    }
    
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
	return "ConditionsTreated [nodeId=" + nodeId + ", conditions=" + conditions + "]";
    }

    
}
