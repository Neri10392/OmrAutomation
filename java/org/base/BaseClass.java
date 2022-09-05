package org.base;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}
	public void addHeaders(Headers headers) {
	
		reqSpec=RestAssured.given().headers(headers);

}
	public void addQueryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void basicAuth(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);

	}

	public void addPathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}
	public void addBodyObj(Object body) {
		reqSpec = reqSpec.body(body);
	}
	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}

	public Response requestMethodType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endPoint);

			break;
		case "PUT":
			response = reqSpec.put(endPoint);
			break;
		case "POST":
			response = reqSpec.post(endPoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endPoint);
			break;
		default:
			break;
		}
		return response;
	}

	public static int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}

	public String getAsString(Response response) {
		String asString = response.asString();
		return asString;

	}

	public String getAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;

	}
}
