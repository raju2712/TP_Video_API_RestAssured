package ShopperStack;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class FindShopperDataByShopperId {

	@Test
	public void findShopperDataByShopperId() {
		
		given().relaxedHTTPSValidation().
		get("https://www.shoppersstack.com/shopping/shoppers/134876").then().log().all();
	}
}
