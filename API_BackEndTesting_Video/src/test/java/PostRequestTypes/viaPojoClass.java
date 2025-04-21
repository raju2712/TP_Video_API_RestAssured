package PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import pojoClassUtility.ProjectPojo;

public class viaPojoClass {

	@Test
	public void postDataToServer() {
	
		//Create an object to pojo class
		Random random = new Random();
		int randNum = random.nextInt(1000);
		
		ProjectPojo ppObj = new ProjectPojo("ABC"+randNum, "Raju", "Created", 0);
		
	given().contentType(ContentType.JSON).body(ppObj).when()
	.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
}}
