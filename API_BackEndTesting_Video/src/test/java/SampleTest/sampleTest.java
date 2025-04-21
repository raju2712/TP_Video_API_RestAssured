package SampleTest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class sampleTest {

	@Test
	public void SampleTest() {
		
		Response resp = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(resp.prettyPrint());
	}
}
