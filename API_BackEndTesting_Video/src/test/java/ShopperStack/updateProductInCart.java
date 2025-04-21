package ShopperStack;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class updateProductInCart {

	@Test
	public void UpdateAproductInCart() {
		
		 String URI = "https://www.shoppersstack.com/shopping/shoppers/134876/carts/298388";
	     String authToken = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWp1cmFtaWtwbUBnbWFpbC5jb20gU0hPUFBFUiIsImV4cCI6MTc0Mzg2NzI5NywiaWF0IjoxNzQzODMxMjk3fQ.WxDoDnSlEdepKC3YcTslz_R78nfDxs2kS7zXbaeMLic";
	        
		JSONObject jObj = new JSONObject();
		jObj.put("productId", 20);
		jObj.put("quantity", 20);
		
		given().header("Authorization", "Bearer " + authToken)
		.relaxedHTTPSValidation().contentType(ContentType.JSON)
		.body(jObj.toJSONString()).when()
		.put(URI).then().assertThat()
		.statusCode(200).log().all();
	}
}
