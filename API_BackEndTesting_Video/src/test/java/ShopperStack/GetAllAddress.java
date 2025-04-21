package ShopperStack;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllAddress {

	@Test
	public void getAllAddress() {
		
	    String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWp1cmFtaWtwbUBnbWFpbC5jb20gU0hPUFBFUiIsImV4cCI6MTc0Mzg4MTQ0MywiaWF0IjoxNzQzODQ1NDQzfQ.cOG4fPDZbH0fQ1skMLKDH7pqROMHvfkJ1Vg3CGFYq3Q";

		given().auth().oauth2(authToken).relaxedHTTPSValidation()
		.when().get("https://www.shoppersstack.com/shopping/shoppers/235453/address").then().log().all();
	}
}
