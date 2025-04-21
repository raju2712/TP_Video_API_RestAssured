package CRUDoperationWithoutBBD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PUT {

	@Test(priority = 3)
	public void CompleteUpdateDataToServer() {
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("createdBy", "ABC");
		jsonObj.put("projectName", "ABC111");
		jsonObj.put("status", "Created");
		jsonObj.put("teamSize", 0);
		
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jsonObj.toJSONString());
		
		Response resp = req.put("http://49.249.28.218:8091/project/NH_PROJ_19519");
		resp.then().log().all();
		resp.then().assertThat().statusCode(200);
	}
}
