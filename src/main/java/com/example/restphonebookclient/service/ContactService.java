package com.example.restphonebookclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.restphonebookclient.client.RestPhonebookClient;
import com.rest.phonebook.model.Contact;

@Service
public class ContactService {
	@Autowired
private RestPhonebookClient restClient;
	
	public Contact getContactById(long userId , long phonebookId , long contactId) {
		HttpEntity<String> requestEntity=new HttpEntity<String>(null,restClient.getHeaders());
		String targetUrl=restClient.getServerURL()+"users/"+userId+"/phonebooks/"+phonebookId+"/contacts/"+contactId;
		
		ResponseEntity<Contact>  responseEntity=restClient.getRest().exchange(targetUrl,HttpMethod.GET,requestEntity,Contact.class);
		return responseEntity.getBody();
	}
	public List<Contact> getAllContact (long userId, long phonebookId){
		HttpEntity<String> requestEntity=new HttpEntity<String>(null,restClient.getHeaders());
		String targetUrl=restClient.getServerURL()+"users/"+userId+"/phonebooks/"+phonebookId+"/contacts";
		ResponseEntity<List<Contact>> responseEntity=
				restClient
				.getRest()
				.exchange(targetUrl,HttpMethod.GET,requestEntity,new ParameterizedTypeReference<List<Contact>>() {});
		
		return responseEntity.getBody();
	}
}
