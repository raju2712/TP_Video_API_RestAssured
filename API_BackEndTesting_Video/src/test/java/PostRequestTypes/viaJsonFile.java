package PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.io.File;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class viaJsonFile {

	public void postDataToServer() {

		File file = new File("./Project.json");
		
		given().contentType(ContentType.JSON).body(file).when().post("http://49.249.28.218:8091/addProject")
		.then().assertThat().statusCode(201).log().all();
	}
}
