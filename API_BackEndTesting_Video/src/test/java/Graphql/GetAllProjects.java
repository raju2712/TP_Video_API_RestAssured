package Graphql;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjects {

	@Test
	public void getAllProjects() {
		String query = "{ getAllProjects{ projectId projectName status } }";
		given().body(query).when().post("http://49.249.28.218:8091/getAll").then().log().all();
	}
	
	//Precise Control on Project
	@Test
	public void getProjectProjectName() {
		String query = "{ getAllProjects{ projectName } }";
		given().body(query).when().post("http://49.249.28.218:8091/getAll").then().log().all();
	}
	
	@Test
	public void getAllProjectId() {
		String query = "{ getAllProjects{ projectId } }";
		given().body(query).when().post("http://49.249.28.218:8091/getAll").then().log().all();
	}
	
	@Test
	public void getAllProjectsStatus() {
		String query = "{ getAllProjects{ status } }";
		given().body(query).when().post("http://49.249.28.218:8091/getAll").then().log().all();
	}
}
