package PostRequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class viaHashMap {

	@Test
	public void postDataToServer() {
		
		HashMap<String, Object> Hmap = new HashMap();
		Hmap.put("createdBy", "Raju");
		Hmap.put("projectName", "ABCDEFG");
		Hmap.put("teamSize", 0);
		Hmap.put("status", "Created");
		
		given().contentType(ContentType.JSON).body(Hmap).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	}
}
