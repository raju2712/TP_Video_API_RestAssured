package ShopperStack;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProductsFromWishlist {

	@Test
	public void getAllProductsFromWishlist() {
		
	    String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWp1cmFtaWtwbUBnbWFpbC5jb20gU0hPUFBFUiIsImV4cCI6MTc0Mzg2NzI5NywiaWF0IjoxNzQzODMxMjk3fQ.WxDoDnSlEdepKC3YcTslz_R78nfDxs2kS7zXbaeMLic";

		given().header("Authorization", "Bearer " + authToken).relaxedHTTPSValidation()
		.when().get("https://www.shoppersstack.com/shopping/shoppers/134876/wishlist")
		.then().assertThat().statusCode(200).log().all();
	}
}
