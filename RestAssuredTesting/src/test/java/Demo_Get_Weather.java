import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Demo_Get_Weather {

	@Test
	void Demo_Get_Weather_City() {
		
		RestAssured.baseURI="http://10.10.17.55:8888/ameyorestapi/fw/getSystemConfigStringValue";
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//Response response=httpRequest.request(Method.GET,"/Hyderabad");
		
		Response response=httpRequest.request(Method.GET,"?key=dataTableaaSearchField");
		httpRequest.header("sessionId","d723-5f893767-ses-mona_admin-KCheXL0x-80");
		
		
         String responsedata=response.getBody().asString();
		
		System.out.println("repsonsedata is:" +responsedata);
		
		int statuscode= response.getStatusCode();
		System.out.println("statuscodeprinting"+statuscode);
		
		String statusline=response.getStatusLine();
		System.out.println("statuscodeprinting"+statusline);
		Assert.assertEquals(200, statuscode);
	}
	
}
