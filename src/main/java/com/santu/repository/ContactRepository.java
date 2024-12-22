package com.santu.repository;

import com.santu.entities.Contact;
import com.santu.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository <Contact, Long>{
}
