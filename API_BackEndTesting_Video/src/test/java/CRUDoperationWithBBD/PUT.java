package CRUDoperationWithBBD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class PUT {

	@Test
	public void CompleteUpdateDataToServer() {
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("createdBy", "ABC");
		jsonObj.put("projectName", "ABC001");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		given().contentType(ContentType.JSON).body(jsonObj.toJSONString()).when()
		.put("http://49.249.28.218:8091/project/NH_PROJ_19527").then().assertThat().statusCode(200)
		.log().all();
		
		}
}
