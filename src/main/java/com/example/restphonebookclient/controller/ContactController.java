package com.example.restphonebookclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restphonebookclient.service.ContactService;
import com.rest.phonebook.model.Contact;

@RestController
@RequestMapping("/users/{userId}/phonebooks/{phonebookId}/contacts")
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@GetMapping("/{contactId}")
	public ResponseEntity<Contact> getContactTelphoneById(
			@PathVariable("userId") long userId,
			@PathVariable("phonebookId") long phonebookId,
			@PathVariable("contactId") long contactId) {

		
		return  new ResponseEntity<Contact>(contactService.getContactById(userId, phonebookId, contactId),HttpStatus.OK);
		
	}
	@GetMapping()
	public ResponseEntity<List<Contact>> getContactTelphoneById(
			@PathVariable("userId") long userId,
			@PathVariable("phonebookId") long phonebookId
			) {

		
		return  new ResponseEntity<List<Contact>>(contactService.getAllContact(userId, phonebookId),HttpStatus.OK);
		
	}

}
