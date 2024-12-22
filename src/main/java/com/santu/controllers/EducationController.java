//package com.santu.controllers;
//
//
//
//import com.santu.dto.request.EducationRequest;
//import com.santu.dto.response.EducationResponse;
//
//import com.santu.service.impl.EducationServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
//@RestController
//@RequestMapping("/api/educations")
//public class EducationController {
//
//    @Autowired
//    private EducationServiceImpl educationService;
//
//    @PostMapping("/{userId}")
//    public ResponseEntity<EducationResponse> addEducation(
//            @PathVariable Long userId,
//            @RequestBody EducationRequest request) {
//        EducationResponse response = educationService.addEducation(userId, request);
//        return ResponseEntity.ok(response);
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<EducationResponse>> getEducationsByUserId(@PathVariable Long userId) {
//        List<EducationResponse> responses = educationService.getEducationsByUserId(userId);
//        return ResponseEntity.ok(responses);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<EducationResponse> updateEducation(
//            @PathVariable Long id,
//            @RequestBody EducationRequest request) {
//        EducationResponse response = educationService.updateEducation(id, request);
//        return ResponseEntity.ok(response);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
//        educationService.deleteEducation(id);
//        return ResponseEntity.noContent().build();
//    }
//}
