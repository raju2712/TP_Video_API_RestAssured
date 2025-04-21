package Graphql;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class FindProjectByProjectId {

	@Test
	public void findProjectByProjectId() {
		String query = "{ findProject(projectId:\"NH_PROJ_24417\"){ projectId projectName status createdBy teamSize } }";
		given().body(query).when().post("http://49.249.28.218:8091/getAll").then().log().all();
	}
}
