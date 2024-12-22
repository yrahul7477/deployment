package com.santu.services.interfac;

import com.santu.entities.Contact;
import com.santu.entities.User;

public interface ContactService {

    Contact saveContact(Contact contact);

    User findUserByEmail(String email);  // New method to find user by email
}
