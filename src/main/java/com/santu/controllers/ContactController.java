package com.santu.controllers;

import com.santu.dto.request.ContactRequest;
import com.santu.dto.response.ContactResponse;
import com.santu.entities.Contact;
import com.santu.entities.User;
import com.santu.services.interfac.ContactService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = RequestMethod.POST)
@RestController
@RequestMapping("/api/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<?> createContact(@Valid @RequestBody ContactRequest contactRequest) {
        // Get the authenticated user's email from SecurityContext
        String email = getAuthenticatedUserEmail();

        // Find the user by their email (user is fetched from database)
        User user = contactService.findUserByEmail(email);

        if (user == null) {
            // Return a BadRequest with an error message if the user is not found
            return ResponseEntity.badRequest().body("User not found");
        }

        // Map ContactRequest DTO to Contact entity
        Contact contact = new Contact();
        contact.setSubject(contactRequest.getSubject());
        contact.setMessage(contactRequest.getMessage());
        contact.setUser(user);  // Associate the logged-in user

        // Save the contact with the user associated
        Contact savedContact = contactService.saveContact(contact);

        // Return the ContactResponse DTO with the saved contact details
        ContactResponse contactResponse = new ContactResponse(
                savedContact.getId(),
                savedContact.getSubject(),
                savedContact.getMessage(),
                savedContact.getUser().getId()  // Returning userId in the response
        );

        return ResponseEntity.ok(contactResponse);
    }

    // Helper method to get the authenticated user's email
    private String getAuthenticatedUserEmail() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();  // Assuming username is used as email in authentication
        }
        return null;
    }
}
