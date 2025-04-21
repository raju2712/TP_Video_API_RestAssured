package SampleTest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class sampleTestUsingMethodChaining {

	@Test
	public void getRequest() {
		
		//get("https://reqres.in/api/users?page=2").prettyPrint();
		get("https://reqres.in/api/users?page=2").then().log().all();
		
	}
}
