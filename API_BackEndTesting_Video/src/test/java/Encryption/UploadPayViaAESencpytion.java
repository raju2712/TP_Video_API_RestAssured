package Encryption;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class UploadPayViaAESencpytion {  

	@Test
	public void AES() throws Exception {
		
		EncryptAndDecryptUtility ed = new EncryptAndDecryptUtility();
		
		String jBody = "{ \"employee\": { \"empId\":\"NH_02939\", \"designation\": \"Accountant1713\", \"dob\": \"\", \"email\": \"syamlal201@gmail.com\", \"empName\": \"Syamlal2959\", \"experience\": 10.0, \"mobileNo\": \"9937605332\", \"project\": \"NH_PROJ_14506\", \"role\": \"user\", \"username\": “syamlal@757” }, \"basicPlusVda\": 0.0, \"hra\": 0.0, \"insurance\": 0.0, \"lta\": 0.0, \"lwf\": 0.0, \"netPay\": 5000, \"payroll_id\": 2837, \"pf\": 0.0, \"pt\": 0.0, \"stat_bonus\": 0.0, \"status\": “Disabled” }";
		String jReqBody = ed.encrypt(jBody, "Ac03tEam@j!tu_#1");
		System.out.println(jReqBody);
		
		Response resp = given().body(jReqBody).when().put("http://49.249.28.218:8091/payroll");
		resp.then().log().all();
		
		String jRespBody = ed.decrypt(resp.getBody().asString(), "Ac03tEam@j!tu_#1");
		System.out.println(jRespBody);
	
	}
}
