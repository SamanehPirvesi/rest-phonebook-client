package com.rest.phonebook.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Contact {

	private long contact_id;
	private String name;
	private String tellNumber;

	public Contact() {
	}

	public Contact(String name, String tellNumber) {
		this.name = name;
		this.tellNumber = tellNumber;
	}

	public long getContact_id() {
		return contact_id;
	}

	public void setContact_id(long contact_id) {
		this.contact_id = contact_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTellNumber() {
		return tellNumber;
	}

	public void setTellNumber(String tellNumber) {
		this.tellNumber = tellNumber;
	}


}
