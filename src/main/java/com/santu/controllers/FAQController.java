package com.santu.controllers;

import com.santu.dto.request.FAQRequest;
import com.santu.dto.response.FAQResponse;
import com.santu.services.impl.FAQServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = RequestMethod.GET)
@RestController
@RequestMapping("/api/faqs")
public class FAQController {

    @Autowired
    private FAQServiceImpl faqService;

    // GET all FAQs
    @GetMapping
    public ResponseEntity<List<FAQResponse>> getAllFAQs() {
        List<FAQResponse> faqResponses = faqService.getAllFAQs();
        return ResponseEntity.ok(faqResponses);
    }

    // GET FAQ by ID
    @GetMapping("/{id}")
    public ResponseEntity<FAQResponse> getFAQById(@PathVariable Long id) {
        FAQResponse faqResponse = faqService.getFAQById(id);
        return ResponseEntity.ok(faqResponse);
    }

    // POST a new FAQ or multiple FAQs
    @PostMapping
    public ResponseEntity<?> createFAQs(@RequestBody List<FAQRequest> faqRequests) {
        if (faqRequests.size() == 1) {
            FAQResponse createdFAQ = faqService.createFAQ(faqRequests.get(0));
            return ResponseEntity.ok(createdFAQ);
        } else {
            List<FAQResponse> createdFAQs = faqService.createFAQs(faqRequests);
            return ResponseEntity.ok(createdFAQs);
        }
    }

    // PUT (update) an FAQ
    @PutMapping("/{id}")
    public ResponseEntity<FAQResponse> updateFAQ(@PathVariable Long id, @RequestBody FAQRequest faqRequest) {
        FAQResponse updatedFAQ = faqService.updateFAQ(id, faqRequest);
        return ResponseEntity.ok(updatedFAQ);
    }

    // DELETE an FAQ
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFAQ(@PathVariable Long id) {
        faqService.deleteFAQ(id);
        return ResponseEntity.ok().build();
    }
}
