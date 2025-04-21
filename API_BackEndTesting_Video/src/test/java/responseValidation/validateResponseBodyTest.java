package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;

public class validateResponseBodyTest {

	@Test
	public void validateResponseBody() {
		
		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();
		
		resp.then().assertThat().body("numberOfElements", Matchers.equalTo(20));
		resp.then().assertThat().body("pageable.sort.unsorted", Matchers.equalTo(true));
		resp.then().assertThat().body("content[0].projectId", Matchers.equalTo("White_PROJ_888"));
		resp.then().assertThat().body("content[2].projectId", Matchers.equalTo("Turdo_PROJ_123"));
		
		//To get all project Ids
		List<String> projectIds = resp.jsonPath().get("content[*].projectId");
		System.out.println(projectIds);
		
//		Object NoOfEle = resp.jsonPath().get("numberOfElements");
//		System.out.println(NoOfEle);
//		
//		Object data = resp.jsonPath().get("pageable.sort.unsorted");
//		System.out.println(data);
//		
//		Object data2 = resp.jsonPath().get("content[0].projectId");
//		System.out.println(data2);
	}

}
