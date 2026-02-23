package com.example.contactmanager.controller;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.repository.ContactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/contacts")
public class ContactController {

    private final ContactRepository repository;

    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return repository.save(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
    }
}