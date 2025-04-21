package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class RegisterAsShopper {
	@Test
	public void RegisterAshopper() {
		JSONObject jObj = new JSONObject();
		jObj.put("city", "Vellore");
		jObj.put("country", "India");
		jObj.put("email", "rr123@gmail.com");
		jObj.put("firstName", "RR");
		jObj.put("gender", "MALE");
		jObj.put("lastName", "RR");
		jObj.put("password", "Rr@123");
		jObj.put("phone", 7894561230l);
		jObj.put("state", "Tamilnadu");
		jObj.put("zoneId", "ALPHA");
		
		given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(jObj.toJSONString())
		.when().post("https://www.shoppersstack.com/shopping/shoppers").then().log().all();
		
		
	}

}
