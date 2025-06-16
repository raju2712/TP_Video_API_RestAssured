package PostRequestTypes;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class viaHashMap {

	@Test
	public void postDataToServer() {   //Mostly used to pass multiple cookies
		
		HashMap<String, Object> Hmap = new HashMap();
		Hmap.put("createdBy", "Raju");
		Hmap.put("projectName", "ABCDEFG");
		Hmap.put("teamSize", 0);
		Hmap.put("status", "Created");
		
		given().contentType(ContentType.JSON).body(Hmap).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	}
}
