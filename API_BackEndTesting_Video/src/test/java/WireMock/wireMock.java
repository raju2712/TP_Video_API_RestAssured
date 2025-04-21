package WireMock;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class wireMock {

	@Test
	public void postDataToServer() {
		JSONObject jObj = new JSONObject();
		jObj.put("debitCardNum", "1234567887654321");
		jObj.put("cvv", "543");
		jObj.put("expDate", "28/30");
		
		
		given().contentType(ContentType.JSON).body(jObj.toJSONString()).when()
		.post("http://localhost:9999/debitCard").then().assertThat().statusCode(200).log().all();
		
	}
}
