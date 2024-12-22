package com.santu.services.impl;


import com.santu.dto.request.TestimonialRequest;
import com.santu.dto.response.TestimonialResponse;
import com.santu.entities.Testimonial;
import com.santu.repository.TestimonialRepository;
import com.santu.services.interfac.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Override
    public List<TestimonialResponse> getAllTestimonials() {
        return testimonialRepository.findAll().stream()
                .map(testimonial -> new TestimonialResponse(
                        testimonial.getId(),
                        testimonial.getName(),
                        testimonial.getRole(),
                        testimonial.getRating(),
                        testimonial.getFeedback(),
                        testimonial.getImagePath()))
                .collect(Collectors.toList());
    }

    @Override
    public TestimonialResponse getTestimonialById(Long id) {
        Testimonial testimonial = testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found with id " + id));
        return new TestimonialResponse(
                testimonial.getId(),
                testimonial.getName(),
                testimonial.getRole(),
                testimonial.getRating(),
                testimonial.getFeedback(),
                testimonial.getImagePath());
    }

    @Override
    public TestimonialResponse createTestimonial(TestimonialRequest testimonialRequest) {
        Testimonial testimonial = new Testimonial();
        testimonial.setName(testimonialRequest.getName());
        testimonial.setRole(testimonialRequest.getRole());
        testimonial.setRating(testimonialRequest.getRating());
        testimonial.setFeedback(testimonialRequest.getFeedback());
        testimonial.setImagePath(testimonialRequest.getImagePath());

        Testimonial savedTestimonial = testimonialRepository.save(testimonial);
        return new TestimonialResponse(
                savedTestimonial.getId(),
                savedTestimonial.getName(),
                savedTestimonial.getRole(),
                savedTestimonial.getRating(),
                savedTestimonial.getFeedback(),
                savedTestimonial.getImagePath());
    }

    @Override
    public TestimonialResponse updateTestimonial(Long id, TestimonialRequest testimonialRequest) {
        Testimonial testimonial = testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found with id " + id));

        testimonial.setName(testimonialRequest.getName());
        testimonial.setRole(testimonialRequest.getRole());
        testimonial.setRating(testimonialRequest.getRating());
        testimonial.setFeedback(testimonialRequest.getFeedback());
        testimonial.setImagePath(testimonialRequest.getImagePath());

        Testimonial updatedTestimonial = testimonialRepository.save(testimonial);
        return new TestimonialResponse(
                updatedTestimonial.getId(),
                updatedTestimonial.getName(),
                updatedTestimonial.getRole(),
                updatedTestimonial.getRating(),
                updatedTestimonial.getFeedback(),
                updatedTestimonial.getImagePath());
    }

    @Override
    public void deleteTestimonial(Long id) {
        Testimonial testimonial = testimonialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Testimonial not found with id " + id));
        testimonialRepository.delete(testimonial);
    }
}
