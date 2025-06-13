package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TypesOfAuthentication {
	
	@Test
	public void BasicAuth() {   //Internal APIs, quick testing  //by giving username and password 
		
		given()
		  .auth().basic("rmgyantra", "rmgy@9999").log().all()
		.when()
		  .get("http://49.249.28.218:8091/login")
		.then()
		.log().all();
	}
	
	@Test
	public void DigestAuth() {  //Every time need to login
		
		given()
		  .auth().digest("rmgyantra", "rmgy@9999").log().all()
		.when()
		  .get("http://49.249.28.218:8091/login")
		.then()
		.log().all();
	}
	
	@Test
	public void PreEmptiveAuth() {  //Only one time need to login
		
		given()
		  .auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		  .get("http://49.249.28.218:8091/login")
		.then()
		.log().all();
	}
	
	@Test
	public void BearerToken() {
		
		given().header("Authorization", "Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia")
		.when().get("http://49.249.28.218:8091/projects")
		.then()
		.log().all();
	}
	
	@Test
	public void Oauth_onePointZero() {
		
		Response resp = given().auth().oauth("consumerKey", "consumerSecret", "accessToken", "secretToken")
	                    .when().get("/oauth1-endpoint");

		resp.then().log().all();
	
	}
	
	@Test
	public void Oauth_twoPointZero() {
		
		//To generate a token
		Response resp = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		
		resp.then().log().all();
		
		String token = resp.jsonPath().get("access_token");
		
		//Passing a token
		given().auth().oauth2(token)
		.get("http://49.249.28.218:8091/admin/payrolls").then().log().all();
	
	}
	
	@Test
	public void apiKey() {
		
		//In header
		given().header("x-api-key", "your_api_key").when().get("/api-key-endpoint");
		
		//In queryParam
		given().queryParam("api_key", "your_api_key").when().get("/api-key-endpoint");

	}
	
	
}
