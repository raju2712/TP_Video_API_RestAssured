package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PlaceAnOrder {
	
	@Test
	public void placeAnOrder() {
		
	    String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJycjEyM0BnbWFpbC5jb20gU0hPUFBFUiIsImV4cCI6MTc0Mzg4Mjg5NywiaWF0IjoxNzQzODQ2ODk3fQ.oSYLQMFt3waVSQZ1JNYyp2tiFia-NgS-JjvUHA1NgQQ";

		JSONObject jObj = new JSONObject();
		jObj.put("addressId", 111348);
		jObj.put("buildingInfo", "string");
		jObj.put("city", "string");
		jObj.put("country", "string");
		jObj.put("landmark", "string");
		jObj.put("name", "string");
		jObj.put("phone", "string");
		jObj.put("pincode", "string");
		jObj.put("state", "string");
		jObj.put("streetInfo", "string");
		jObj.put("type", "string");
		
		given().auth().oauth2(authToken).relaxedHTTPSValidation().contentType(ContentType.JSON)
		.body(jObj.toJSONString()).when().post("https://www.shoppersstack.com/shopping/shoppers/235453/orderss")
		.then().log().all();
	}

}
