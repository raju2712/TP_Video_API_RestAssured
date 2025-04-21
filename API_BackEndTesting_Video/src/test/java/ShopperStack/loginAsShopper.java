package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class loginAsShopper {

	@Test
	public void LoginAsShopper() {
		JSONObject jObj = new JSONObject();
		jObj.put("role", "SHOPPER");
//		jObj.put("email", "rajuramikpm@gmail.com");
//		jObj.put("password", "Raju@123");
		
		jObj.put("email", "rr123@gmail.com");
		jObj.put("password", "Rr@123");
		
		given().relaxedHTTPSValidation()
		.contentType(ContentType.JSON).body(jObj.toJSONString()).when()
		.post("https://www.shoppersstack.com/shopping/users/login").then().log().all();
		
	}
}
