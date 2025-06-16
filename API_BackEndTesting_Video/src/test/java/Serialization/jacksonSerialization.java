package Serialization;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(value = { "createdBy", "teamSize", "projectName", "status" })

@JsonIgnoreProperties(value = { "teamSize" ,"status" })

class project { // POJO Class
	
	private String projectName;
	@JsonProperty(value = "created By")
	private String createdBy;
	private String status;
	private int teamSize;

	public project(String projectName, String createdBy, String status, int teamSize) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.status = status;
		this.teamSize = teamSize;
	}
	
	// Empty Constructor for De-serialization 
	private project() { }

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

}

public class jacksonSerialization {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		project pObj = new project("ABCDEFGHIJKLM", "Raju", "Created", 0);
		ObjectMapper om = new ObjectMapper(); // Java to json
		om.writeValue(new File("./Project.json"), pObj);
		System.out.println("===END===");
	}

}
