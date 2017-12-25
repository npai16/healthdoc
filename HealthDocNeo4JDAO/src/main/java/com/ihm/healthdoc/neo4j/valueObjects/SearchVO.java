package com.ihm.healthdoc.neo4j.valueObjects;

import com.ihm.healthdoc.neo4j.constants.SearchType;

public class SearchVO {
    
    String searchString;
    String location;    
    SearchType searchType;   // optional        
    
    public String getSearchString() {
        return searchString;
    }
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public SearchType getSearchType() {
        return searchType;
    }
    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }     
}