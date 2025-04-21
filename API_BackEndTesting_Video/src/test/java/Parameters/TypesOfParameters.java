package Parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class TypesOfParameters {

	@Test
	public void pathParam() {
		given().pathParam("projectId", "NH_PROJ_19813").when()
		.get("http://49.249.28.218:8091/project/{projectId}").then().log().all();
	}
	
	@Test
	public void queryParam() {
	
		given().queryParam("teamSize", 10).log().all()  //parameter will visible in response body's URL
		.when().get("http://49.249.28.218:8091/project").then().log().all();
	}
	
	@Test
	public void formParam() {
		
		given().formParam("createdBy", "Raju").log().all()  //parameter will not visible in response body's URL
		.when().post("http://49.249.28.218:8091/project").then().log().all();
	}
	
	@Test
	public void ParamPara() {
		given().param("createdBy", "Raju").log().all()
		.when().post("http://49.249.28.218:8091/project").then().log().all();
		//with post,put,patch method parameter not shown in url,shown in request body (it acts like Form Parameter)
		
		given().param("createdBy", "Raju").log().all()
		.when().get("http://49.249.28.218:8091/project").then().log().all();
		//with get method parameter shown in url,not shown in request body (it acts like Query Parameter)

		
	}
}
