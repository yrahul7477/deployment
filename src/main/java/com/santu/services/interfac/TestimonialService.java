package com.santu.services.interfac;



import com.santu.dto.request.TestimonialRequest;
import com.santu.dto.response.TestimonialResponse;

import java.util.List;

public interface TestimonialService {

    List<TestimonialResponse> getAllTestimonials();

    TestimonialResponse getTestimonialById(Long id);

    TestimonialResponse createTestimonial(TestimonialRequest testimonialRequest);

    TestimonialResponse updateTestimonial(Long id, TestimonialRequest testimonialRequest);

    void deleteTestimonial(Long id);
}
