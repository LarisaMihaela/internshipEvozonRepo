package com.evozon.steps.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import org.junit.Test;

import com.evozon.tools.entities.Login;
import com.evozon.tools.entities.User;
import com.tools.factories.LoginFactory;
import com.tools.utils.InstanceUtils;
import com.tools.utils.SerenitySessionUtils;
import  com.evozon.utils.ApiUrlConstants;
import com.evozon.utils.SerenityKeyConstants;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ApiLoginSteps extends AbstractApiSteps {
	@Steps
	ApiLoginSteps apiLoginSteps;
	
	private static final long serialVersionUID = 1L;

	/*
	//Method used to login from Api -JSON
	@Step
	public void loginAsUser() {
		Login loginRequest = LoginFactory.getLoginInstance();
		User userResponse = createResource(ApiUrlConstants.LOGIN, loginRequest, User.class);

		loginRequest.setUser((User) InstanceUtils.mergeObjects(loginRequest.getUser(), userResponse));
		AbstractApiSteps.extraHeaders.put("Authorization", "Basic " + userResponse.getAuthenticationToken());

		SerenitySessionUtils.putOnSession(SerenityKeyConstants.USER, loginRequest.getUser());
	}*/
	
	@SuppressWarnings("static-access")
	@Step
	public void apiLoginAsUser() throws Exception {
		User user = new User();
		user.setEmail("helloworld20@yahoo.com");
		user.setPassword("helloworld2015");
		Login login = new Login();
		login.setUser(user);
		System.out.println(apiLoginSteps.postHTML("http://qa1.dev.evozon.com/customer/account/loginPost", login.getUser()));
		System.out.println(apiLoginSteps.getHTML("http://qa1.dev.evozon.com/"));
	}
	
	public static String getHTML(String urlToRead) throws Exception // returns a HTML String
    {
        URL url=new URL(urlToRead); //create URL obj
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
	
	 public static String getFormKey(String response){ // extracts the value with REGEX
	     Pattern pattern = Pattern.compile("type=\"hidden\" value=\"(.*?)\"", Pattern.CASE_INSENSITIVE);
	     Matcher matcher = pattern.matcher(response);
	     if (matcher.find()){
	         return matcher.group(1);
	     }
	     return null;
	    }

	 public static String postHTML(String urlToWrite, Object requestBody) throws Exception{
	     HttpClient httpClient= HttpClients.createDefault();
	     HttpPost httpPost=new HttpPost(urlToWrite);
	     Field[] fields=requestBody.getClass().getDeclaredFields();
	     List<NameValuePair> params=new ArrayList<NameValuePair>();
	     String getResponse=getHTML("http://qa1.dev.evozon.com/customer/account/login");
	     String formKey=getFormKey(getResponse);
	     params.add(new BasicNameValuePair("form_key",formKey));
	     for(int i=0;i<fields.length;i++){
	    	 fields[i].setAccessible(true);
	         if(fields[i].get(requestBody)!=null) {
	        	 params.add(new BasicNameValuePair(fields[i].getName(), fields[i].get(requestBody).toString()));
	        	 }else{
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
}
