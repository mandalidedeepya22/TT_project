package com.example.contactmanager.controller;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getAllContacts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Boolean favorite,
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir) {
        
        List<Contact> contacts = contactRepository.findAll();
        
        // Apply filters
        if (category != null && !category.isEmpty()) {
            contacts = contacts.stream()
                .filter(c -> c.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        }
        
        if (favorite != null) {
            contacts = contacts.stream()
                .filter(c -> c.isFavorite() == favorite)
                .collect(Collectors.toList());
        }
        
        if (search != null && !search.isEmpty()) {
            String searchTerm = search.toLowerCase();
            contacts = contacts.stream()
                .filter(c -> c.getName().toLowerCase().contains(searchTerm) ||
                           c.getEmail().toLowerCase().contains(searchTerm) ||
                           c.getPhone().toLowerCase().contains(searchTerm))
                .collect(Collectors.toList());
        }
        
        // Apply sorting
        contacts.sort((c1, c2) -> {
            int result = 0;
            switch (sortBy.toLowerCase()) {
                case "name":
                    result = c1.getName().compareToIgnoreCase(c2.getName());
                    break;
                case "email":
                    result = c1.getEmail().compareToIgnoreCase(c2.getEmail());
                    break;
                case "phone":
                    result = c1.getPhone().compareToIgnoreCase(c2.getPhone());
                    break;
                case "created":
                    result = c1.getCreatedAt().compareTo(c2.getCreatedAt());
                    break;
            }
            return sortDir.equalsIgnoreCase("desc") ? -result : result;
        });
        
        return contacts;
    }

    @GetMapping("/categories")
    public List<String> getCategories() {
        return contactRepository.findDistinctCategories();
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        contact.setCreatedAt(java.time.LocalDateTime.now());
        contact.setUpdatedAt(java.time.LocalDateTime.now());
        return contactRepository.save(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        return contactRepository.findById(id)
            .map(contact -> {
                contact.setName(contactDetails.getName());
                contact.setEmail(contactDetails.getEmail());
                contact.setPhone(contactDetails.getPhone());
                contact.setCategory(contactDetails.getCategory());
                contact.setFavorite(contactDetails.isFavorite());
                contact.setPhotoUrl(contactDetails.getPhotoUrl());
                contact.setUpdatedAt(java.time.LocalDateTime.now());
                return ResponseEntity.ok(contactRepository.save(contact));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/favorite")
    public ResponseEntity<Contact> toggleFavorite(@PathVariable Long id) {
        return contactRepository.findById(id)
            .map(contact -> {
                contact.setFavorite(!contact.isFavorite());
                contact.setUpdatedAt(java.time.LocalDateTime.now());
                return ResponseEntity.ok(contactRepository.save(contact));
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
