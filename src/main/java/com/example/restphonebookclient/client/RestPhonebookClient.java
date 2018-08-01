package com.example.restphonebookclient.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@PropertySource("classpath:/config.properties")
public class RestPhonebookClient {

	@Value("${serverURL}")
	private String serverURL;
   
	@Autowired
	private RestTemplate rest;
	private HttpHeaders headers;

	public RestPhonebookClient() {

	}
  
	public RestPhonebookClient(RestTemplate rest) {
		this.rest = rest;
	}

	public void setRest(RestTemplate rest) {
		this.rest = rest;
	}

	public String getServerURL() {
		return serverURL;
	}

	public void setServerURL(String serverURL) {
		this.serverURL = serverURL;
	}

	public RestTemplate getRest() {
		return rest;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	@SuppressWarnings("serial")
	@Autowired
	private void setHeaders() {

		this.headers = new HttpHeaders() {
		};
	}
}