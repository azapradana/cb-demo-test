package com.devtest.demo.service;

import java.util.List;

import com.devtest.demo.model.Contact;

public interface ContactService {
	Contact saveContact(Contact con);
	List<Contact> getAllContact();
	Contact getContactById(Long id); 
	Contact updateContact(Contact con, Long id);
	void deleteContact(Long id);
}
