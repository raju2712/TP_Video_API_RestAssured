package DDT;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelFileUtility.excelFileUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class addMultipleProjectTest {

	@Test(dataProvider = "getData")
	public void createProject(String pName,String status) {
		
		String reqBody = "{\r\n"
				+ "  \"createdBy\": \"Raju\",\r\n"
				+ "  \"projectName\": \""+pName+"\",\r\n"
				+ "  \"status\": \""+status+"\",\r\n"
				+ "  \"teamSize\": 0\r\n"
				+ "}";
		
		given().contentType(ContentType.JSON).body(reqBody).when().post("http://49.249.28.218:8091/addProject")
		.then().log().all();
	}
	
	@DataProvider
	public Object[][] getData() throws IOException, Throwable {
		
		excelFileUtility eutil = new excelFileUtility();
		int lastRowCount = eutil.getRowCount("Sheet1");
		
		Object[][] objArr = new Object [lastRowCount][2];
		
		for(int i=0; i<lastRowCount; i++) {
			
			objArr[i][0] = eutil.toReadDataFromExcel("Sheet1", i+1, 0);
			objArr[i][1] = eutil.toReadDataFromExcel("Sheet1", i+1, 1);
		}
		
		return objArr;
	}
}
