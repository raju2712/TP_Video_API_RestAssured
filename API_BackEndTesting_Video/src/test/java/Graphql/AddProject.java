package Graphql;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class AddProject {

	@Test
	public void addProject() {
		String query = "mutation { addProject( projectName: \"RR_000\", teamSize: 0, createdBy: \"Raju\", createdOn: \"2025-04-15\", status: \"Created\" ) { projectId projectName teamSize createdBy createdOn status } }";
		given().body(query).when().post("http://49.249.28.218:8091/addProject-graphql").then().log().all();
	}
}
