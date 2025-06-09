package DataMasking;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import pojoClassUtility.ProjectPojo;

public class dataMasking {

	@Test
	public void postDataToServer() {
		
		Random random = new Random();
		int randNum = random.nextInt(1000);
		
		ProjectPojo ppObj = new ProjectPojo("ABC"+randNum, "Raju", "Created", 0);
		
		given().config(config.logConfig(LogConfig.logConfig().blacklistHeader("Content-Type","Keep-Alive")))
		.contentType(ContentType.JSON).body(ppObj).when().post("http://49.249.28.218:8091/addProject")
		.then().assertThat().statusCode(201).log().all();
	
	}
}
