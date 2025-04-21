package PostRequestTypes;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class viaJsonObject {

	@Test
	public void postDataToServer() {
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Raju");
		jObj.put("projectName", "ABCDEFGH");
		jObj.put("teamSize", 0);
		jObj.put("status", "Created");
		
		given().contentType(ContentType.JSON).body(jObj.toJSONString()).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	}
}
