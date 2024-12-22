package com.santu.controllers;


import com.santu.dto.request.TestimonialRequest;
import com.santu.dto.response.TestimonialResponse;
import com.santu.services.interfac.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialService testimonialService;

    // Get all testimonials
    @GetMapping
    public ResponseEntity<List<TestimonialResponse>> getAllTestimonials() {
        List<TestimonialResponse> testimonials = testimonialService.getAllTestimonials();
        return new ResponseEntity<>(testimonials, HttpStatus.OK);
    }

    // Get testimonial by ID
    @GetMapping("/{id}")
    public ResponseEntity<TestimonialResponse> getTestimonialById(@PathVariable Long id) {
        TestimonialResponse testimonial = testimonialService.getTestimonialById(id);
        return new ResponseEntity<>(testimonial, HttpStatus.OK);
    }

    // Create a new testimonial
    @PostMapping
    public ResponseEntity<TestimonialResponse> createTestimonial(@RequestBody TestimonialRequest testimonialRequest) {
        TestimonialResponse createdTestimonial = testimonialService.createTestimonial(testimonialRequest);
        return new ResponseEntity<>(createdTestimonial, HttpStatus.CREATED);
    }

    // Update a testimonial by ID
    @PutMapping("/{id}")
    public ResponseEntity<TestimonialResponse> updateTestimonial(
            @PathVariable Long id,
            @RequestBody TestimonialRequest testimonialRequest) {
        TestimonialResponse updatedTestimonial = testimonialService.updateTestimonial(id, testimonialRequest);
        return new ResponseEntity<>(updatedTestimonial, HttpStatus.OK);
    }

    // Delete a testimonial by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTestimonial(@PathVariable Long id) {
        testimonialService.deleteTestimonial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
