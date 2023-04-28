package com.devtest.demo.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devtest.demo.model.Contact;
import com.devtest.demo.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	private ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	@PostMapping()
	public ResponseEntity<Contact> saveContact(@RequestBody Contact con){
		System.out.println("con data:"+con.toString());
	    return new ResponseEntity<Contact>(contactService.saveContact(con), HttpStatus.CREATED);
	}

	
	@GetMapping
	public List<Contact> getAllContact(){
		return contactService.getAllContact();
	}
	@GetMapping("{id}")
	public ResponseEntity<Contact> getContactById(@PathVariable("id") Long id){
		return new ResponseEntity<Contact>(contactService.getContactById(id),HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Contact> updateContact(@PathVariable("id") Long id,@RequestBody Contact con){
		return new ResponseEntity<Contact>(contactService.updateContact(con,id),HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteContact(@PathVariable("id") Long id){
		contactService.deleteContact(id);
		return new ResponseEntity<String>("Contact deleted!",HttpStatus.OK);
	}
	
}