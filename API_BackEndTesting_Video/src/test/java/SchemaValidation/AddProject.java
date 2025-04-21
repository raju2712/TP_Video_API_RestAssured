package SchemaValidation;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import pojoClassUtility.ProjectPojo;

public class AddProject {

	@Test
	public void postDataToServer() {

		Random random = new Random();
		int randNum = random.nextInt(1000);

		ProjectPojo ppObj = new ProjectPojo("RR" + randNum, "Raju", "Created", 0);

		Response resp = given().contentType(ContentType.JSON).body(ppObj).when()
				        .post("http://49.249.28.218:8091/addProject");
		resp.then().log().all();
		
		//For Schema Validation
		resp.then().body(JsonSchemaValidator.matchesJsonSchema(new File(".\\src\\test\\resources\\jsonschema.json")));
		resp.then().body("msg", Matchers.instanceOf(String.class));     //value of msg key is in string format
		resp.then().body("teamSize", Matchers.instanceOf(int.class));   //value of teamSize key is in int format
		
	}
}
