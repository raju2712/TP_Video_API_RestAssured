package RequestChaining;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassUtility.ProjectPojo;
import pojoClassUtility.pojoClassForRequestChaining;

public class Scenario_2_CreateProjectThenAddEmployee {
	
	@Test
	public void AddEmployeeToProject() {
		
		Random random = new Random();
		int randNum = random.nextInt(1000);

		// API - 1 --- Add Project
		// Create an object to pojo class
		ProjectPojo ppObj = new ProjectPojo("ABC" + randNum, "Raju", "Created", 0);

		Response resp = given().contentType(ContentType.JSON).body(ppObj).when()
				.post("http://49.249.28.218:8091/addProject");
		resp.then().assertThat().statusCode(201).log().all();
		
		//Capture Project Name from Response
		Object pName = resp.jsonPath().get("projectName");
		System.out.println(pName);
		
		// API - 2 --- Add Employee to the created Project
		// Create an object to pojo class
		pojoClassForRequestChaining employPojo = new pojoClassForRequestChaining("Tester", "27/01/2000", "raju123@gmail.com", 
				                                 "Raju"+randNum, 3, "7896541230", pName, "ROLE_EMPLOYEE", "Raju"+randNum);
		
		given().contentType(ContentType.JSON).body(employPojo).when().post("http://49.249.28.218:8091/employees")
		.then().assertThat().statusCode(201).log().all();
	}

}
