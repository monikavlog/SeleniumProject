package com.restassured;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseClass {
	RequestSpecification httprequest;
	Response response;
	String responsebody;
	//String statusCode;
	FileInputStream inputstream;
	Properties properties;
	String URL;
	String lastURL;
	String sessionid;
	String contentType;
	FileOutputStream outputstream;
	
	
	
	@BeforeTest
	public void initialSetup() throws IOException {
		
		//Read data from properties file
		properties=new Properties();
			inputstream =new FileInputStream("/home/ameyo/eclipse-workspace/RestAssuredTesting/src/test/java/com/restassured/testng.properties");
			properties.load(inputstream);
			URL=properties.getProperty("uri");
			sessionid=properties.getProperty("sessionid");
			contentType=properties.getProperty("content-type");
			
		//Extra work for storing value in properties file
				outputstream=new FileOutputStream("/home/ameyo/eclipse-workspace/RestAssuredTesting/src/test/java/com/restassured/testng.properties");
				properties.setProperty("browser", "chrome");
				properties.store(outputstream, null);
		
		
		//URL used for each api
		RestAssured.baseURI=URL;
		
		//Request object creation
		httprequest=RestAssured.given();
		
		//header pass
		httprequest.header("sessionId",sessionid);
		httprequest.header("content-type",contentType);
		
		}
	
	

	@Test(priority=1)
	public void getRequest() {
		
		lastURL=properties.getProperty("lasturl");
		//Response object creation
		response=httprequest.request(Method.GET,lastURL);
		responsebody =response.getBody().asString();
		
	}
	
	
	@AfterTest
	public void afterTest() throws IOException {
		System.out.println("responseBodyof get" +responsebody);
		int statuscode1 =response.getStatusCode();
		Assert.assertEquals(200, statuscode1);
		
		}
	
}
