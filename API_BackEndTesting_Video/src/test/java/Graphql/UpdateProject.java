package Graphql;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class UpdateProject {

	@Test
	public void addProject() {
		String query = "mutation { updateProject( projectId: \"NH_PROJ_24362\" projectName: \"RR_0001\", teamSize: 0, createdBy: \"Raju\", createdOn: \"2025-04-15\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		given().body(query).when().post("http://49.249.28.218:8091/addProject-graphql").then().log().all();
	}
}
