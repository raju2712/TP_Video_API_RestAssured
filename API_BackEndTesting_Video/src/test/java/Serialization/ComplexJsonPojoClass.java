package Serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class POJO {

	String projectName;
	String projectstatus;
	int teamSize;
	List<String> teamMember;
	ProjectManager projectManager;

	public POJO(String projectName, String projectstatus, int teamSize, List<String> teamMember,ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}

	public String getProjectstatus() {
		return projectstatus;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	public int getTeamSize() {
		return teamSize;
	}

	public void setTeamMember(List<String> teamMember) {
		this.teamMember = teamMember;
	}

	public List<String> getTeamMember() {
		return teamMember;
	}

	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}

	public ProjectManager getProjectManager() {
		return projectManager;
	}

}

class ProjectManager {

	String name;
	String empId;
	
	public ProjectManager(String name, String empId) {
		super();
		this.name = name;
		this.empId = empId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpId() {
		return empId;
	}

}

public class ComplexJsonPojoClass {

	public static void main(String[] args) throws IOException {

		List<String> list = new ArrayList<String>();
		list.add("Raju");
		list.add("John");
		list.add("Punitha");
		list.add("Divya");
		
		ProjectManager pm = new ProjectManager("Chukki", "TP123");

		POJO pObj = new POJO("ABCD", "Created", 0, list, pm);
		ObjectMapper om = new ObjectMapper();
		om.writeValue(new File("./Proj.json"), pObj);

	}

}
