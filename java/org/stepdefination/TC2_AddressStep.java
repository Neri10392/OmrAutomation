package org.stepdefination;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Endpoint;

import org.base.BaseClass;
import org.endpoints.Endpoints;
import org.junit.Assert;
import org.pages.AddAddress_Input_Pojo;
import org.pages.DeleteAddress_Output_Pojo;
import org.pages.UpdateAddress_Input_Pojo;
import org.pages.UpdateAddress_Output_pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TC2_AddressStep extends BaseClass {
	Response response;
	String logtoken;
	String AddressId;

	@Given("User add headers and bearer authentication for accessing address endpoints")
	public void userAddHeadersAndBearerAuthenticationForAccessingAddressEndpoints() {
		List<Header> h = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		h.add(h1);
		h.add(h2);
		h.add(h3);
		Headers headers = new Headers(h);

		addHeaders(headers);

	}

	@When("User add request body for Add new address {string},{string},{string},{string},{string},{string},{string},{string}, {string} and {string}")
	public void userAddRequestBodyForAddNewAddressAnd(String first_name, String last_name, String mobile,
			String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		AddAddress_Input_Pojo addAddress_Input_Pojo = new AddAddress_Input_Pojo(first_name, last_name, mobile,
				apartment, Integer.valueOf(state), Integer.valueOf(city), Integer.valueOf(country), zipcode, address,
				address_type);
	}

	@When("User send {string} request for AddUserAddress endpoint")
	public void userSendRequestForAddUserAddressEndpoint(String string) {

		Response response = requestMethodType("PUT", Endpoints.ADDUSERADDRESS);
	}

	@Then("User verify the login response message matches {string}")
	public void userVerifyTheLoginResponseMessageMatches(String string) {
		org.pages.AddAddress_Output_Pojo addAddress_Output_Pojo = response.as(org.pages.AddAddress_Output_Pojo.class);
		String message = addAddress_Output_Pojo.getMessage();
		System.out.println(message);
		int address_id = addAddress_Output_Pojo.getAddress_id();
		AddressId = String.valueOf(address_id);
	}

	@When("User add request body for  update address {string},{string},{string},{string},{string},{string},{string},{string},{string}, {string} and {string}")
	public void userAddRequestBodyForUpdateAddressAnd(String address_id, String first_name, String last_name,
			String mobile, String apartment, String state, String city, String country, String zipcode, String address,
			String address_type) {
		UpdateAddress_Input_Pojo updateAddress_Input_Pojo = new UpdateAddress_Input_Pojo(address_id, first_name,
				last_name, mobile, apartment, Integer.valueOf(state), Integer.valueOf(city), Integer.valueOf(country),
				zipcode, address, address_type);

	}

	@When("User send {string} request for AddUpdateAddress endpoint")
	public void userSendRequestForAddUpdateAddressEndpoint(String string) {
		response = requestMethodType("DELETE", Endpoints.UPDATEUSERADDRESS);
	}

	@Then("User verify the UpdateUserAddress response message matches {string}")
	public void userVerifyTheUpdateUserAddressResponseMessageMatches(String string) {
		UpdateAddress_Output_pojo updateAddress_Output_pojo = response.as(UpdateAddress_Output_pojo.class);
		int status = updateAddress_Output_pojo.getStatus();
		System.out.println(status);
		Assert.assertEquals("Verify staus", 200, status);

	}

	@When("User add request body for update address {string}")
	public void userAddRequestBodyForUpdateAddress(String string) {
		response = requestMethodType("DELETE", Endpoints.DELETEUSERADDRESS);
	}

	@Then("User verify the deleteUserAddress response message matches {string}")
	public void userVerifyTheDeleteUserAddressResponseMessageMatches(String string) {
		DeleteAddress_Output_Pojo deleteAddress_Output_Pojo = response.as(DeleteAddress_Output_Pojo.class);
		int status = deleteAddress_Output_Pojo.getStatus();
		System.out.println(status);
		Assert.assertEquals("Verify staus", 200, status);

	}
	@When("User add request body for get address {string}")
	public void userAddRequestBodyForGetAddress(String string) {
		response = requestMethodType("GET", Endpoints.GETUSERADDRESS);
	
	}

}
