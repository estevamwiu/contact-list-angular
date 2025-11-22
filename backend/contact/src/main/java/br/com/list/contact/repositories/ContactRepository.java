package br.com.list.contact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.list.contact.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    
}
