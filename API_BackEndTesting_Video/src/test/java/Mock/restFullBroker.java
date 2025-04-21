package Mock;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class restFullBroker {
	
	public int bookingId;
	public String TOKEN;

	@Test
	public void createBooking() {
		
		File file = new File("./createBooking.json");
		Response resp = given().contentType(ContentType.JSON).body(file).when()
		.post("https://restful-booker.herokuapp.com/booking");
		
		resp.then().assertThat().statusCode(200).log().all();
		resp.then().assertThat().contentType(ContentType.JSON) .log().all();
		
		resp.then().assertThat().body("booking.firstname", Matchers.equalTo("Raju"));
		resp.then().assertThat().body("booking.lastname", Matchers.equalTo("R"));
		resp.then().assertThat().body("booking.totalprice", Matchers.equalTo(2712));
		resp.then().assertThat().body("booking.bookingdates.checkin", Matchers.equalTo("2025-04-17"));
		resp.then().assertThat().body("booking.bookingdates.checkout", Matchers.equalTo("2025-04-20"));
		resp.then().assertThat().body("booking.additionalneeds", Matchers.equalTo("Dinner"));
		
		bookingId = resp.jsonPath().get("bookingid");
	
	}
	
	@Test
	public void createToken() {
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("username" , "admin");
		jsonObj.put("password" , "password123");
		
		Response resp = given().contentType(ContentType.JSON).body(jsonObj.toJSONString()).when()
				.post("https://restful-booker.herokuapp.com/auth");
		
		resp.then().log().all();
		
		TOKEN = resp.jsonPath().get("token");
	}
	
	@Test
	public void partialUpdateBooking() {
		
		String updateBody = "{\n" +
                "    \"firstname\" : \"Ramesh\",\n" +
                "    \"lastname\" : \"Raju\"\n" +
                "}";
		
		given().contentType(ContentType.JSON).cookie("token", TOKEN)
        .body(updateBody).when().patch("https://restful-booker.herokuapp.com/booking/" + bookingId)
		.then().assertThat().statusCode(200).log().all();
		
	}
}
