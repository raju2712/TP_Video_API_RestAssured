package CRUDoperationWithoutBBD;

import io.restassured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST {
	
	@Test(priority = 1)
	public void postDataToServer() {
		
		JSONObject jsonObj = new JSONObject();
	    jsonObj.put("createdBy", "ABC");
	    jsonObj.put("projectName", "ABC008");
	    jsonObj.put("status", "Created");
	    jsonObj.put("teamSize", 0);
		  
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObj.toJSONString());
		
		Response resp = req.post("http://49.249.28.218:8091/addProject");
		resp.then().log().all();
		resp.then().assertThat().statusCode(201);
		
	}

}
