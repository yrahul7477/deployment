package com.santu.services.impl;

import com.santu.entities.Contact;
import com.santu.entities.User;
import com.santu.repository.ContactRepository;
import com.santu.repository.UserRepository;
import com.santu.services.interfac.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);  // Find user by email (optional)
    }
}
