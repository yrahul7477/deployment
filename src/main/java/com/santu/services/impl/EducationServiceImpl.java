//package com.santu.service.impl;
//
//import com.santu.dto.request.EducationRequest;
//import com.santu.dto.response.EducationResponse;
//import com.santu.entities.Education;
//import com.santu.entities.User;
//import com.santu.repository.EducationRepository;
//import com.santu.repository.UserRepository;
//
//import com.santu.services.interfac.EducationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class EducationServiceImpl implements EducationService {
//
//    @Autowired
//    private EducationRepository educationRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public EducationResponse addEducation(Long userId, EducationRequest request) {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
//
//        Education education = new Education();
////        education.setUser(user);
//        education.setInstitute(request.getInstitute());
//        education.setDegree(request.getDegree());
//        education.setFieldOfStudy(request.getFieldOfStudy());
//        education.setRegistrationNo(request.getRegistrationNo());
//        education.setRollNo(request.getRollNo());
//        education.setStartingYear(request.getStartingYear());
//        education.setEndingYear(request.getEndingYear());
//        education.setResult(request.getResult());
//        education.setResultOutOf(request.getResultOutOf());
//
//        Education savedEducation = educationRepository.save(education);
//
//        return mapToResponse(savedEducation);
//    }
//
//    @Override
//    public List<EducationResponse> getEducationsByUserId(Long userId) {
//        List<Education> educations = educationRepository.findByUserId(userId);
//        return educations.stream()
//                .map(this::mapToResponse)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public EducationResponse updateEducation(Long id, EducationRequest request) {
//        Education education = educationRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Education not found with ID: " + id));
//
//        education.setInstitute(request.getInstitute());
//        education.setDegree(request.getDegree());
//        education.setFieldOfStudy(request.getFieldOfStudy());
//        education.setRegistrationNo(request.getRegistrationNo());
//        education.setRollNo(request.getRollNo());
//        education.setStartingYear(request.getStartingYear());
//        education.setEndingYear(request.getEndingYear());
//        education.setResult(request.getResult());
//        education.setResultOutOf(request.getResultOutOf());
//
//        Education updatedEducation = educationRepository.save(education);
//
//        return mapToResponse(updatedEducation);
//    }
//
//    @Override
//    public void deleteEducation(Long id) {
//        Education education = educationRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Education not found with ID: " + id));
//        educationRepository.delete(education);
//    }
//
//    private EducationResponse mapToResponse(Education education) {
//        return new EducationResponse(
//                education.getInstitute(),
//                education.getDegree(),
//                education.getFieldOfStudy(),
//                education.getRegistrationNo(),
//                education.getRollNo(),
//                education.getStartingYear(),
//                education.getEndingYear(),
//                education.getResult(),
//                education.getResultOutOf()
//        );
//    }
//}
