package com.devtest.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devtest.demo.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
