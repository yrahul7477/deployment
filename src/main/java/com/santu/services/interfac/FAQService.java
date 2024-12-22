package com.santu.services.interfac;

import com.santu.dto.request.FAQRequest;
import com.santu.dto.response.FAQResponse;

import java.util.List;

public interface FAQService {
    List<FAQResponse> getAllFAQs();
    FAQResponse getFAQById(Long id);
    FAQResponse createFAQ(FAQRequest faqRequest);
    FAQResponse updateFAQ(Long id, FAQRequest faqRequest);
    void deleteFAQ(Long id);
    List<FAQResponse> createFAQs(List<FAQRequest> faqRequests);  // New method to handle multiple FAQs
}
