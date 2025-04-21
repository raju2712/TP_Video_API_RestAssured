package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AddAddress {
	@Test
	public void addAddress() {
		
	    String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJycjEyM0BnbWFpbC5jb20gU0hPUFBFUiIsImV4cCI6MTc0Mzg4Mjg5NywiaWF0IjoxNzQzODQ2ODk3fQ.oSYLQMFt3waVSQZ1JNYyp2tiFia-NgS-JjvUHA1NgQQ";

		JSONObject jObj = new JSONObject();
		jObj.put("addressId", 0);
		jObj.put("buildingInfo", "ABC");
		jObj.put("city", "ABC");
		jObj.put("country", "ABC");
		jObj.put("landmark", "ABC");
		jObj.put("name", "ABC");
		jObj.put("phone	", "8523697410");
		jObj.put("pincode", "560010");
		jObj.put("state", "ABC");
		jObj.put("streetInfo", "ABC");
		jObj.put("type", "ABC");
		
		given().auth().oauth2(authToken).relaxedHTTPSValidation()
		.contentType(ContentType.JSON).body(jObj.toJSONString())
		.when().post("https://www.shoppersstack.com/shopping/shoppers/235453/address").then().log().all();
	}

}
