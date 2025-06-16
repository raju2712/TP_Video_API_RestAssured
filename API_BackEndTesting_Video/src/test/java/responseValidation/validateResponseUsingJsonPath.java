package responseValidation;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.response.Response;

public class validateResponseUsingJsonPath {

	@Test
	public boolean validateThroughJsonPath() {

		Response resp = given().get("http://49.249.28.218:8091/projects-paginated");
		resp.then().log().all();

		List<String>  Project_Name = JsonPath.read(resp.asString(), ".content[*].projectName");
		// System.out.println(Project_Name);
		String expData = "RAPO123";

		boolean flag = false;
		
		for (String str : Project_Name) {
			if (str.equals(expData)) {
				System.out.println(expData + " is available ========== PASS");
				flag = true;
			} else {
				System.out.println(expData + " is not available ========== FAIL");
			}
		}
		return flag;

	}
}
