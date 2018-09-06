package com.evozon.steps.api;


import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;
import com.evozon.steps.serenity.AbstractSteps;
import com.evozon.utils.ApiUrlConstants;


public class AbstractApiSteps extends AbstractSteps{

	private static final long serialVersionUID = 1L;
	private static RequestSpecification tokenSpec = null;
	public static Map<String, String> extraHeaders = new HashMap<String, String>();
	
	public static RequestSpecification getSpecWithExtraHeaders(){
		
		tokenSpec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.setBaseUri(ApiUrlConstants.BASE_URI)
				.addHeader("User-Agent", "web_agent")
				.addHeaders(extraHeaders)
				.build();
		
		return tokenSpec;
	}
	
	
	

	protected static <T> T createResource (String path, Object requestBody, Class<T> responseClass) {
		return given().relaxedHTTPSValidation()
				.spec(getSpecWithExtraHeaders())
				.body(requestBody)
				.when().post(path)
				.then()
				.assertThat().statusCode(anyOf(is(201), is(200), is(302)))
				.extract().as(responseClass);
	}

	protected static <T> T updateResource (String path, Object requestBody, Class<T> responseClass, Object...params) {
		return given().relaxedHTTPSValidation()
				.spec(getSpecWithExtraHeaders())
				.body(requestBody)
				.when().put(path, params)
				.then()
				.assertThat().statusCode(anyOf(is(201), is(200), is(302)))
				.extract().as(responseClass);
	}
	
	protected static String createResource (String path, Object requestBody) {
		return given()
				.relaxedHTTPSValidation()
				.spec(getSpecWithExtraHeaders())
				.body(requestBody)
				.when().post(path)
				.then()
				.assertThat().statusCode(anyOf(is(201),is(204), is(200), is(302)))
			    .extract().response().asString();
	}

	protected void uploadResource (String path, String resourcePath) {
		given()
			.relaxedHTTPSValidation()
			.spec(getSpecWithExtraHeaders())
			.multiPart(new File(resourcePath))
			.when().post(path)
			.then()
			.assertThat().statusCode(anyOf(is(201),is(204), is(200), is(302)));
	}
}