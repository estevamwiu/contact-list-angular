package br.com.list.contact.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.list.contact.entities.Contact;
import br.com.list.contact.repositories.ContactRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {

    @Autowired
        private ContactRepository repository;

    public List<Contact> getContacts() {
        return repository.findAll();
    }

    public Contact getContactById (long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Contato não encontrado."));
    }

    public void deleteContactById (long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }

        else {
            throw new EntityNotFoundException("Contato não existente.");
        }
    }

    public Contact saveContact (Contact contact) {
        return repository.save(contact);
    }
}