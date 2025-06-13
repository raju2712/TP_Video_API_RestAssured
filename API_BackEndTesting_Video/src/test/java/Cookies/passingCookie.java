package Cookies;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.response.*;
import net.minidev.json.JSONObject;

public class passingCookie {

	@Test
	public void sendCookies() {
		
		given().cookie("username","Raju").log().all().when()
		.get("http://49.249.28.218:8091/project/NH_PROJ_24129").then().log().all();
	}
	
	@Test
	public void sendMultipleCookies() {
		
		HashMap<String, String> cookieMap = new HashMap();
		cookieMap.put("JSESSIONID", "abcd1234");
		cookieMap.put("USER", "raju");
		cookieMap.put("cookie", "UserName");

		given().cookies(cookieMap).when().get("/dashboard").then().log().all();

	}
	
	@Test
	public void getCookieFromResponse() {
		
    Response resp = given().when().get("https://example.com");
    resp.then().log().all();

    // Get all cookies
   Map<String, String> allCookies = resp.getCookies();
    System.out.println("All Cookies: " + allCookies);

    // Get a specific cookie
    String singleCookies = resp.getCookie("JSESSIONID");
    System.out.println("JSESSIONID: " + singleCookies);
    
	}
	
	@Test
	public void validateCookie() {
		
		given().when().get("https://example.com").then()
		    .cookie("JSESSIONID")             // Check presence
		    .cookie("USER", equals("raju"));  // Check value

	}
		

	
}

