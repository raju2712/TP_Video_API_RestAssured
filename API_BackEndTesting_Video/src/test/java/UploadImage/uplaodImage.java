package UploadImage;

import static io.restassured.RestAssured.given;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class uplaodImage {

	@Test
	public void postDataToServer() {
		
		File img = new File("C:\\Users\\FloweR KinG\\Downloads\\kitty-cat-kitten-pet-45201.jpeg");
		
		given().multiPart(img)
		.when().post("https://petstore.swagger.io/v2/pet/9223372036854775807/uploadImage").then().log().all();
	}
}
