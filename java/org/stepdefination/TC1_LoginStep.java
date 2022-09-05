package org.stepdefination;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.base.BaseClass;
import org.endpoints.Endpoints;
import org.pages.Login_Output_Pojo;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC1_LoginStep extends BaseClass {

	String logtoken;
	Response response ;
	
	@Given("User add header")
	public void userAddHeader() {
		
		addHeader("accept", "application/json");
		
	}
	@Given("User add basic authentication for login")
	public void userAddBasicAuthenticationForLogin() {
		
		basicAuth("neriyarasan@gmail.com", "Neri@10392");

		
	}
	@When("User send {string} request for login endpoint")
	public void userSendRequestForLoginEndpoint(String string) {
		
		 response = requestMethodType("POST", Endpoints.POSTMANBASICAUTHLOGIN);
	
	}
	@Then("User verify the status code is {int}")
	public void userVerifyTheStatusCodeIs(Integer int1) {
		
		int statusCode = getStatusCode(response);
        System.out.println(statusCode);
        Assert.assertEquals(statusCode, 200,"Verify statusCode");
		
	}
	@Then("User verify the login response body firstName Present as {string} and get the logtoken")
	public void userVerifyTheLoginResponseBodyFirstNamePresentAsAndGetTheLogtoken(String string) {
		Login_Output_Pojo loginOutput = response.as(Login_Output_Pojo.class);

		logtoken = loginOutput.getData().getLogtoken();



	
	}

}
