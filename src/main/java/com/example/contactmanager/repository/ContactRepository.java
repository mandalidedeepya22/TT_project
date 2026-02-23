package com.example.contactmanager.repository;

import com.example.contactmanager.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
    @Query("SELECT DISTINCT c.category FROM Contact c WHERE c.category IS NOT NULL")
    List<String> findDistinctCategories();
    
    List<Contact> findByCategory(String category);
    
    @Query("SELECT c FROM Contact c WHERE c.isFavorite = :favorite")
    List<Contact> findByFavorite(@Param("favorite") boolean favorite);
    
    @Query("SELECT c FROM Contact c WHERE LOWER(c.name) LIKE %:search% OR LOWER(c.email) LIKE %:search% OR LOWER(c.phone) LIKE %:search%")
    List<Contact> searchContacts(@Param("search") String search);
}
