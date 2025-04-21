package Cookies;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class passingCookie {

	@Test
	public void postDataToServer() {
		
		given().cookie("username","Raju").log().all().when()
		.get("http://49.249.28.218:8091/project/NH_PROJ_24129").then().log().all();
	}
}
