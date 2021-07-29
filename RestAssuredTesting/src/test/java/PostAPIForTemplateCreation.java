import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostAPIForTemplateCreation {

	
	@Test(enabled=false)
	void TemplateCreation() {
		
		//We are passing URI 
		RestAssured.baseURI="https://node55.ameyo.net:8443/ameyorestapi/cm";
		
		//httprequest object
		RequestSpecification httprequest=RestAssured.given();
		
		//header of request
		httprequest.header("sessionId","d848-60f694fe-ses-MultiCCManager-7x22PD65-17");
		httprequest.header("content-type","application/json");
		
		
		//Body params
		JSONObject requestparameter=new JSONObject();
		requestparameter.put("templateName", "Fourthtemplatemine");
		
		//Convert Above string type Body Params into json
		httprequest.body(requestparameter.toJSONString());
		
		
		//Request type : Post method
		Response response =httprequest.request(Method.POST, "/addHangupCauseTemplate");
		
		
		//Now Print the response body as a string
		String responsebody =response.getBody().asString();
		System.out.println("Body of post method:"+responsebody);
		
		//Assertions used for statuscode
		System.out.println("statuscode of response:" +response.getStatusCode());
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, "512");
		
		
		//Assertion used for message parameter shown in Body
		System.out.println("messageofresponsebody" +response.jsonPath().getString("message"));
		String responsemessage=response.jsonPath().getString("message");
		Assert.assertEquals(responsemessage,"TemplateCreation");
		
		
		
	}
	
	@Test(enabled=false)
	
	public void GetHangupCauseTemplate() {
		
		//Passed the baseURI
		RestAssured.baseURI="https://node55.ameyo.net:8443/ameyorestapi/cm";
		
		//Create Request Object
	RequestSpecification httprequest=RestAssured.given();
	
	//pass header
	httprequest.header("sessionId","d170-60f7f41f-ses-MultiCCManager-U8knpZqd-1");
	
	//Create Response
	Response response=httprequest.request(Method.GET,"/getAllHangupCauseTemplate");
	
	//Print this response
	String getResponseBody=response.getBody().asString();
	System.out.println("getRequestResponseBody" +getResponseBody);
	
	
	//gettemplatenamefrom json
	String templateName=response.jsonPath().getString("templateName");
	System.out.println("\n");
	System.out.println("templatenamefromjson:" +templateName);
	
	}
	
	
	
	//UpdateHangupcauseTemplate
	@Test(enabled=false)
	public void updateHangupCauseTemplate() {
		
		//BaseURIpassed
		RestAssured.baseURI="https://node55.ameyo.net:8443/ameyorestapi/cm";
		
		//HttpRequest object creation
		RequestSpecification httpRequest=RestAssured.given();
		
		//Json Object Creation
		JSONObject updateparameter=new JSONObject();
		updateparameter.put("id", "2");
		updateparameter.put("templateName", "changingnewtemplate2");
		
		//convert above body string into json
		httpRequest.body(updateparameter.toJSONString());
		
		//Pass the header
		httpRequest.header("sessionId","d170-60f7f41f-ses-MultiCCManager-U8knpZqd-1");
		httpRequest.header("content-type","application/json");
		
		//Create Response object
		Response response=httpRequest.request(Method.POST,"/modifyHangupCauseTemplate");
		
		//getresponsestatuscode
		int responsecode=response.getStatusCode();
		System.out.println("UpdateRequestkastatusprint" +responsecode);
		
		
	}
	
	
	@Test(priority=4)
	
	public void deleteHangupCauseTemplate() {
		//BaseURIpassed
				RestAssured.baseURI="https://node55.ameyo.net:8443/ameyorestapi/cm";
				
				//HttpRequest object creation
				RequestSpecification httpRequest=RestAssured.given();
				
				//Json Object Creation
				JSONObject updateparameter=new JSONObject();
				updateparameter.put("id", "2");
				
				
				//convert above body string into json
				httpRequest.body(updateparameter.toJSONString());
				
				//Pass the header
				httpRequest.header("sessionId","d170-60f7f41f-ses-MultiCCManager-U8knpZqd-1");
				httpRequest.header("content-type","application/json");
				
				//Create Response object
				Response response=httpRequest.request(Method.POST,"/removeHangupCauseTemplate");
				
				//getresponsestatuscode
				int responsecode=response.getStatusCode();
				System.out.println("removeRequestkastatusprint" +responsecode);
				
		
	}
	
}
