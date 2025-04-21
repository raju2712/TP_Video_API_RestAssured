package RequestChaining;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.locals_return;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassUtility.ProjectPojo;

public class Scenario_1_CreateAndDeleteProject {

	@Test
	public void postDataToServer() {

		Random random = new Random();
		int randNum = random.nextInt(1000);

		// API - 1 --- Add Project
		// Create an object to pojo class
		ProjectPojo ppObj = new ProjectPojo("ABC" + randNum, "Raju", "Created", 0);

		Response resp = given().contentType(ContentType.JSON).body(ppObj).when()
				.post("http://49.249.28.218:8091/addProject");
		resp.then().assertThat().statusCode(201).log().all();
		
		//Capture Project Name from Response
		Object pId = resp.jsonPath().get("projectId");
		System.out.println(pId);
		
		// API - 2 --- Delete Project
		given().delete("http://49.249.28.218:8091/project/"+pId+"")
		.then().log().all();
	  
	}
}
