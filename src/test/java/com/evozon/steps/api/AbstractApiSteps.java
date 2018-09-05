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
	
	public static String getHTML(String urlToRead) throws Exception
    {
        URL url=new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        StringBuilder result = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();

    }
	
	 public static String getFormKey(String response){
	        Pattern pattern = Pattern.compile("type=\"hidden\" value=\"(.*?)\"", Pattern.CASE_INSENSITIVE);
	        Matcher matcher = pattern.matcher(response);
	        if (matcher.find()){
	            return matcher.group(1);
	        }
	        return null;
	    }

	    public static String postHTML(String urlToWrite, Object requestBody) throws Exception
	    {
	        HttpClient httpClient= HttpClients.createDefault();
	        HttpPost httpPost=new HttpPost(urlToWrite);
	        Field[] fields=requestBody.getClass().getDeclaredFields();
	        List<NameValuePair> params=new ArrayList<NameValuePair>();
	        String getResponse=getHTML("http://qa1.dev.evozon.com/customer/account/login");
	        String formKey=getFormKey(getResponse);
	        params.add(new BasicNameValuePair("form_key",formKey));
	        for(int i=0;i<fields.length;i++)
	        {
	            fields[i].setAccessible(true);
	            if(fields[i].get(requestBody)!=null) {
	                params.add(new BasicNameValuePair(fields[i].getName(), fields[i].get(requestBody).toString()));
	            }
	            else
	            {
	                params.add(new BasicNameValuePair(fields[i].getName(), null));
	            }
	        }
	        httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
	        httpPost.setHeader("User-Agent-WW","web_agent");
	        HttpResponse response=httpClient.execute(httpPost);
	        HttpEntity entity=response.getEntity();
	        System.out.println(response.getStatusLine());
	        return entity.toString();

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