package CRUDoperationWithBBD;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST {
	
	@Test
	public void postDataToServer() {
		
		JSONObject jsonObj = new JSONObject();
	    jsonObj.put("createdBy", "ABC");
	    jsonObj.put("projectName", "ABC009");
	    jsonObj.put("status", "Created");
	    jsonObj.put("teamSize", 0);
	    
		given().contentType(ContentType.JSON).body(jsonObj.toJSONString()).when()
		.post("http://49.249.28.218:8091/addProject").then().assertThat().statusCode(201).log().all();
	
		
	}
}
