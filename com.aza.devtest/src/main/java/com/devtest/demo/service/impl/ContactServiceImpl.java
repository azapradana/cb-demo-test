package com.devtest.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devtest.demo.exception.ResourceNotFoundException;
import com.devtest.demo.model.Contact;
import com.devtest.demo.repository.ContactRepository;
import com.devtest.demo.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	private ContactRepository contactRepository;
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public Contact saveContact(Contact con) {
		// TODO Auto-generated method stub
		return contactRepository.save(con);
	}

	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	@Override
	public Contact getContactById(Long id) {
		// TODO Auto-generated method stub
		
		return contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact","id",id.toString()));
	}

	@Override
	public Contact updateContact(Contact con, Long id) {
		// TODO Auto-generated method stub
		Contact existingContact = contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact","id",id.toString()));
		
		existingContact.setName(con.getName());
		existingContact.setPhone(con.getPhone());
		contactRepository.save(existingContact);
		return existingContact;
	}

	@Override
	public void deleteContact(Long id) {
		// TODO Auto-generated method stub
		contactRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Contact","id",id.toString()));
		contactRepository.deleteById(id);
		
	}
}
