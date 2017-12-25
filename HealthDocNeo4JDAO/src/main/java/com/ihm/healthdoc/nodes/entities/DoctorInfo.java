package com.ihm.healthdoc.nodes.entities;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/*
 * The @NodeEntity annotation is used to declare that a POJO class is an entity backed by a node in the graph database. 
 * Entities handled by the OGM must have one empty 
 * public constructor to allow the library to construct the objects.
 * 
 * Entity fields can be annotated with annotations like @Property, @Id, @GeneratedValue, @Transient or @Relationship
 * 
 * 
 * Doctor IS_ASSOCIATED_WITH Department
 * 
 * 
 */
@NodeEntity(label="DOCTOR_INFO")
public class DoctorInfo {
	
    	// @Id @GeneratedValue        
	@GraphId 
	private Long nodeId;
	
	@Property(name="id")
	private String id;
			
	@Property(name="emailID")
	private String emailID;
			
	@Property(name="givenName")
	private String givenName;
	
	@Property(name="lastName")
	private String lastName;
	
	@Property(name="gender")
	private String gender;
	
	@Property(name="address")
	private String address;
	
	@Property(name="location")
	private String location;
	
	@Property(name="phoneNumber")
	private List<String> phoneNumber;
	
	@Property(name="language")
	private List<String> language;
		
	@Property(name="educationDetails")
	private List<String> educationDetails;	
	
	@Property(name="degreeDetails")
	private List<String> degreeDetails;
	
	@Relationship(type="CONDITIONS_TREATED", direction=Relationship.OUTGOING)
	private ConditionsTreated conditionsTreated;	
		
	@Relationship(type="COMPLICATIONS_TREATED", direction=Relationship.OUTGOING)
	private List<ComplicationsInfo> complicationsInfo;
	
	@Relationship(type="PARTICIPATED", direction=Relationship.OUTGOING)
	private List<ConferencePresentation> conferencePresentation;	
	
	@Relationship(type="AWARDED_WITH", direction=Relationship.OUTGOING)
	private List<AwardsRecognition> awardsRecognitions;
	
	@Relationship(type="HAS_PUBLISHED", direction=Relationship.OUTGOING)
	private List<InternationPublication> internationPublications;
	
	@Relationship(type="INVITED_FOR", direction=Relationship.OUTGOING)
	private List<FacultyInvitation> facultyInvitation;
	
	@Relationship(type = "IS_ASSOCIATED_WITH", direction= Relationship.OUTGOING)
	private Department department;
	
	@Relationship(type = "IS_ASSOCIATED_TO", direction= Relationship.OUTGOING)
	private List<Hospital> hospital;

	public DoctorInfo() {
	    System.out.println("In Constructor DoctorInfo ");
	}
	
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

	public String getEmailID() {
	    return emailID;
	}
		
	public String getLastName() {
	    return lastName;
	}

	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}

	public void setEmailID(String emailID) {
	    this.emailID = emailID;
	}

	public String getGivenName() {
	    return givenName;
	}

	public void setGivenName(String givenName) {
	    this.givenName = givenName;
	}

	public List<String> getEducationDetails() {
	    return educationDetails;
	}

	public void setEducationDetails(List<String> educationDetails) {
	    this.educationDetails = educationDetails;
	}

	public List<String> getDegreeDetails() {
	    return degreeDetails;
	}

	public void setDegreeDetails(List<String> degreeDetails) {
	    this.degreeDetails = degreeDetails;
	}

	public ConditionsTreated getConditionsTreated() {
	    return conditionsTreated;
	}

	public void setConditionsTreated(ConditionsTreated conditionsTreated) {
	    this.conditionsTreated = conditionsTreated;
	}

	public List<ComplicationsInfo> getComplicationsInfo() {
	    return complicationsInfo;
	}

	public void setComplicationsInfo(List<ComplicationsInfo> complicationsInfo) {
	    this.complicationsInfo = complicationsInfo;
	}

	public List<ConferencePresentation> getConferencePresentation() {
	    return conferencePresentation;
	}

	public void setConferencePresentation(List<ConferencePresentation> conferencePresentation) {
	    this.conferencePresentation = conferencePresentation;
	}

	public List<AwardsRecognition> getAwardsRecognitions() {
	    return awardsRecognitions;
	}

	public void setAwardsRecognitions(List<AwardsRecognition> awardsRecognitions) {
	    this.awardsRecognitions = awardsRecognitions;
	}

	public List<InternationPublication> getInternationPublications() {
	    return internationPublications;
	}

	public void setInternationPublications(List<InternationPublication> internationPublications) {
	    this.internationPublications = internationPublications;
	}

	public List<FacultyInvitation> getFacultyInvitation() {
	    return facultyInvitation;
	}

	public void setFacultyInvitation(List<FacultyInvitation> facultyInvitation) {
	    this.facultyInvitation = facultyInvitation;
	}		

	public String getGender() {
	    return gender;
	}

	public void setGender(String gender) {
	    this.gender = gender;
	}

	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}

	public List<String> getPhoneNumber() {
	    return phoneNumber;
	}

	public void setPhoneNumber(List<String> phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}

	public List<String> getLanguage() {
	    return language;
	}

	public void setLanguage(List<String> language) {
	    this.language = language;
	}	
	
	public String getLocation() {
	    return location;
	}

	public void setLocation(String location) {
	    this.location = location;
	}
	
	
	public Department getDepartment() {
	    return department;
	}

	public void setDepartment(Department department) {
	    this.department = department;
	}

	
	public List<Hospital> getHospital() {
	    return hospital;
	}

	public void setHospital(List<Hospital> hospital) {
	    this.hospital = hospital;
	}

	@Override
	public String toString() {
	    return "DoctorInfo [nodeId=" + nodeId + ", id=" + id + ", emailID=" + emailID + ", givenName=" + givenName
		    + ", lastName=" + lastName + ", gender=" + gender + ", address=" + address + ", location="
		    + location + ", phoneNumber=" + phoneNumber + ", language=" + language + ", educationDetails="
		    + educationDetails + ", degreeDetails=" + degreeDetails + ", conditionsTreated=" + conditionsTreated
		    + ", complicationsInfo=" + complicationsInfo + ", conferencePresentation=" + conferencePresentation
		    + ", awardsRecognitions=" + awardsRecognitions + ", internationPublications="
		    + internationPublications + ", facultyInvitation=" + facultyInvitation + ", department="
		    + department + ", hospital=" + hospital + "]";
	}

}