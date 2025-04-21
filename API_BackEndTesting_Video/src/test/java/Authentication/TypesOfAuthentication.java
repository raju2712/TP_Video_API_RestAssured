package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TypesOfAuthentication {
	
	@Test
	public void BasicAuth() {
		
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
	public void BearerTokenAuth() {
		
		given()
		  .auth().oauth2("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJsZUN3YUNPai00RXVlbzJkTFFrTmZuLXh2M0F3Nm5ZdWZtS0pINXBFWkNNIn0"
		  		+ ".eyJleHAiOjE3NDM3NTAyNTEsImlhdCI6MTc0Mzc0ODQ1MSwianRpIjoiYjViMzFkYzYtZjc0YS00NWM0LWFkMGMtYzhjMmRjYzdmMzZhIiwiaXNzIjoia"
		  		+ "HR0cDovLzQ5LjI0OS4yOC4yMTg6ODE4MC9hdXRoL3JlYWxtcy9uaW56YSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI0ODVlYTJhYi1kY2MzLTQwOGItOTUx"
		  		+ "Zi04NGMwM2JmZDAwMmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuaW56YS1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiOWIzOWY4NWItNGI1MS00MTFlLWJ"
		  		+ "kOWUtNDBhOTgxMjUxNGY5IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyJodHRwOi8vNDkuMjQ5LjI4LjIxODo4MDkxIl0sInJlYWxtX2FjY2VzcyI"
		  		+ "6eyJyb2xlcyI6WyJkZWZhdWx0LXJvbGVzLW5pbnphIiwib2ZmbGluZV9hY2Nlc3MiLCJhZG1pbiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9h"
		  		+ "Y2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2Nvc"
		  		+ "GUiOiJlbWFpbCBwcm9maWxlIiwic2lkIjoiOWIzOWY4NWItNGI1MS00MTFlLWJkOWUtNDBhOTgxMjUxNGY5IiwiZW1haWxfdmVyaWZpZWQiOmZhbHNlLCJwcm"
		  		+ "VmZXJyZWRfdXNlcm5hbWUiOiJybWd5YW50cmEifQ.HXfeQqBQyFgzK1rPNnzGm66q-4qVb77Kcfx6rw6eiM16YFXXKTN1t7zSB7aXM2xIKBp0q1TfUGoRELb2"
		  		+ "ghNg7nASI7EwpU_BfA7txVYrl2oOaMTpRSys-rPUFpjELa_2GJVptWyzoJHBJgQbbwL1uzheBMe2g_dfu1ZY8okp_r0e9-IYATS8Cp8E20zUuR6q6vo3Pi9-O"
		  		+ "4F6zrnkiI96hwSXj0H7RIFs_Gx--RzFvWme8wtrHHze23Fx7lgk7kSkcSlLESaFcxB6ldHfmT7PKxPTRIc0RCMSFmWLx0aiV_6gsMgJsV0Vbd_G6T4ZSO3kjf"
		  		+ "Z6qvGMOJr2ogFSIoXT-g")
		.when()
		  .get("http://49.249.28.218:8091/projects")
		.then()
		.log().all();
	}
	
	@Test
	public void Oauth_twoPointZero() {
		
		Response resp = given()
		.formParam("client_id", "ninza-client")
		.formParam("client_secret", "gPQBf1Yxew5OMccMhzos1GefIyiSnXzM")
		.formParam("grant_type", "client_credentials")
		.when().post("http://49.249.28.218:8180/auth/realms/ninza/protocol/openid-connect/token");
		
		resp.then().log().all();
		
		String token = resp.jsonPath().get("access_token");
		
		given().auth().oauth2(token)
		.get("http://49.249.28.218:8091/admin/payrolls").then().log().all();
		
	
	}
	
}
