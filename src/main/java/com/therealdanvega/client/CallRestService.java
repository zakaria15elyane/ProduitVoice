package com.therealdanvega.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import lombok.var;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
public class CallRestService {

    private static HttpURLConnection con;
	  public static void main(String[] args) throws IOException, InterruptedException {

			var url = "https://dd5e1934d980.ngrok.io/vokalCall/postaudio";
	        var urlParameters = "name=Jack&occupation=programmer";
	        byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);

	        try {

	            var myurl = new URL(url);
	           var con = (HttpURLConnection) myurl.openConnection();

	            con.setDoOutput(true);
	            con.setRequestMethod("POST");
	            con.setRequestProperty("User-Agent", "Java client");
	            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

	            try (var wr = new DataOutputStream(con.getOutputStream())) {

	                wr.write(postData);
	            }

	            StringBuilder content;

	            try (var br = new BufferedReader(
	                    new InputStreamReader(con.getInputStream()))) {

	                String line;
	                content = new StringBuilder();

	                while ((line = br.readLine()) != null) {
	                    content.append(line);
	                    content.append(System.lineSeparator());
	                }
	            }

	            System.out.println(content.toString());

	        } catch(Exception e) {

	            
	        }
		  
		  
		  
		 /*  HttpPost post = new HttpPost("https://httpbin.org/post");

	        // add request parameter, form parameters
	        List<NameValuePair> urlParameters = new ArrayList<>();
	 

	        post.setEntity(new UrlEncodedFormEntity(urlParameters));

	        try (CloseableHttpClient httpClient = HttpClients.createDefault();
	             CloseableHttpResponse response = httpClient.execute(post)) {

	            System.out.println(EntityUtils.toString(response.getEntity()));
	        }
	  }
	        
	    	*/
    
	  }
    }
