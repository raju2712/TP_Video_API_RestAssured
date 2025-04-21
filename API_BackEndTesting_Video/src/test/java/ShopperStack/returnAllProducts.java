package ShopperStack;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class returnAllProducts {

	@Test
	public void viewProducts() {
		
		given().relaxedHTTPSValidation().
		get("https://www.shoppersstack.com/shopping/products/alpha").then().log().all();
		
	}
}
