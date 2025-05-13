package RequestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Scenario_3_getPayRollInfo {
	
	@Test
	public void sampleTest() {
		
		//API - 1 ---- Get Auth 2.0
		Response resp = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when()
		.post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		resp.then().assertThat().statusCode(200).log().all();
		
		//Capture Project Name from Response
		String token = resp.jsonPath().get("access_token");
		
		//API - 2 ---- Get Pay Roll Info
		given().auth().oauth2(token)
		.get("http://49.249.28.218:8091/admin/payrolls").then().log().all();
	}

}
