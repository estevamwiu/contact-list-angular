package br.com.list.contact.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.list.contact.entities.Contact;

import br.com.list.contact.services.ContactService;

@RestController
@RequestMapping("/contacts")

public class ContactController {
    
    @Autowired
    private ContactService service;

    @GetMapping
    public List <Contact> getContacts() {
        return service.getContacts();
    }

    @GetMapping ("{id}")
    public Contact getContactById(@PathVariable long id) {
        return service.getContactById(id);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity <Void> deleteContactById (@PathVariable long id) {
        service.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity <Contact> saveContact (@RequestBody Contact contact) {
        Contact newContact = service.saveContact(contact);
        
        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(newContact.getId())
        .toUri();
        
        return ResponseEntity.created(location).body(newContact);
    }
}
