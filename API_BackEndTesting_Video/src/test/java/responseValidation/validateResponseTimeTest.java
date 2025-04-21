package responseValidation;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class validateResponseTimeTest {

	@Test
	public void validateResponseTime() {
		
		Response resp = given().get("http://49.249.28.218:8091/projects");
		resp.then().log().all();
		
		long timeTakenInMilliSecond = resp.time();
		long timeTakenInSecond = resp.timeIn(TimeUnit.SECONDS);
		System.out.println(timeTakenInMilliSecond);
		System.out.println(timeTakenInSecond);
		
		resp.then().assertThat().time(Matchers.lessThan(900l));
		resp.then().assertThat().time(Matchers.greaterThan(300l));
		
	    resp.then().assertThat().time(Matchers.both(Matchers.lessThan(900l))
	    .and(Matchers.greaterThan(300l)));
	}
}
