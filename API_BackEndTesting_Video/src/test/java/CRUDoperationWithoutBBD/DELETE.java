package CRUDoperationWithoutBBD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DELETE {
	
	@Test(priority = 5)
	public void deleteDataFromServer() {
		
		Response resp = RestAssured.delete("http://49.249.28.218:8091/project/NH_PROJ_19519");
		resp.then().log().all();
		resp.then().assertThat().statusCode(204);
		
		
	}

}
