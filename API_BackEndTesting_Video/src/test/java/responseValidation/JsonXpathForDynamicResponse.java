package responseValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;
import junit.framework.Assert;

public class JsonXpathForDynamicResponse {

	@Test
	public void validateThroughJsonPath() {

		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();

		// If the given project Id is available then print Project Name
		List<String> Project_Id = JsonPath.read(resp.asString() , "content[*].[?(@.projectName=='netra 678')].projectId");
		// System.out.println(Project_Id);
		String actualProjectId = Project_Id.get(0);

		Assert.assertEquals(actualProjectId, "NH_PROJ_9780");
	}

}
