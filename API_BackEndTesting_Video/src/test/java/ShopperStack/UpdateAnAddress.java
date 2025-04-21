package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateAnAddress {

	@Test
	public void updateAnAddress() {
		
	    String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWp1cmFtaWtwbUBnbWFpbC5jb20gU0hPUFBFUiIsImV4cCI6MTc0Mzg4MTQ0MywiaWF0IjoxNzQzODQ1NDQzfQ.cOG4fPDZbH0fQ1skMLKDH7pqROMHvfkJ1Vg3CGFYq3Q";

		JSONObject jObj = new JSONObject();
		jObj.put("addressId", 0);
		jObj.put("buildingInfo", "ABC");
		jObj.put("city", "ABC");
		jObj.put("country", "India");
		jObj.put("landmark", "ABC");
		jObj.put("name", "ABC");
		jObj.put("phone	", "8523697410");
		jObj.put("pincode", "560010");
		jObj.put("state", "ABC");
		jObj.put("streetInfo", "ABC");
		jObj.put("type", "ABC");
		
		given().auth().oauth2(authToken).relaxedHTTPSValidation().contentType(ContentType.JSON)
		.body(jObj.toJSONString()).when()
		.put("https://www.shoppersstack.com/shopping/shoppers/235453/address/111348").then().log().all();
		
	}
}
