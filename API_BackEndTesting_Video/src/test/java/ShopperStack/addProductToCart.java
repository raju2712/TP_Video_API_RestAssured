package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class addProductToCart {

	@Test
	public void addProductTocart() {
		JSONObject jObj = new JSONObject();
		jObj.put("productId", 20);
		jObj.put("quantity", 2);
		
		given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(jObj.toJSONString())
		.when().post("https://www.shoppersstack.com/shopping/shoppers/134876/carts")
		.then().log().all();
	}
}
