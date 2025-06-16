package ShopperStack;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class AddAddress {
	@Test
	public void addAddress() {
		
	    String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJycjEyM0BnbWFpbC5jb20gU0hPUFBFUiIsImV4cCI6MTc0Mzg4Mjg5NywiaWF0IjoxNzQzODQ2ODk3fQ.oSYLQMFt3waVSQZ1JNYyp2tiFia-NgS-JjvUHA1NgQQ";

		HashMap<String, Object> hMap = new HashMap<String, Object>();
		hMap.put("addressId", 0);
		hMap.put("buildingInfo", "ABC");
		hMap.put("city", "ABC");
		hMap.put("country", "ABC");
		hMap.put("landmark", "ABC");
		hMap.put("name", "ABC");
		hMap.put("phone	", "8523697410");
		hMap.put("pincode", 560010);
		hMap.put("state", "ABC");
		hMap.put("streetInfo", "ABC");
		hMap.put("type", "ABC");
		
		given().header("Authorization", "Bearer " + bearerToken).relaxedHTTPSValidation()
		.contentType(ContentType.JSON).body(hMap.toString())
		.when().post("https://www.shoppersstack.com/shopping/shoppers/235453/address").then().log().all();
	}

}
