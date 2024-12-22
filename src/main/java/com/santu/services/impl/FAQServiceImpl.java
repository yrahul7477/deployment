package com.santu.services.impl;

import com.santu.dto.request.FAQRequest;
import com.santu.dto.response.FAQResponse;
import com.santu.entities.FAQ;
import com.santu.repository.FAQRepository;
import com.santu.services.interfac.FAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FAQServiceImpl implements FAQService {

    @Autowired
    private FAQRepository faqRepository;

    @Override
    public List<FAQResponse> getAllFAQs() {
        return faqRepository.findAll().stream()
                .map(faq -> new FAQResponse(faq.getId(), faq.getQuestion(), faq.getAnswer()))
                .collect(Collectors.toList());
    }

    @Override
    public FAQResponse getFAQById(Long id) {
        FAQ faq = faqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FAQ not found with id " + id));
        return new FAQResponse(faq.getId(), faq.getQuestion(), faq.getAnswer());
    }

    @Override
    public FAQResponse createFAQ(FAQRequest faqRequest) {
        FAQ faq = new FAQ();
        faq.setQuestion(faqRequest.getQuestion());
        faq.setAnswer(faqRequest.getAnswer());
        FAQ savedFAQ = faqRepository.save(faq);
        return new FAQResponse(savedFAQ.getId(), savedFAQ.getQuestion(), savedFAQ.getAnswer());
    }

    @Override
    public FAQResponse updateFAQ(Long id, FAQRequest faqRequest) {
        FAQ faq = faqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FAQ not found with id " + id));
        faq.setQuestion(faqRequest.getQuestion());
        faq.setAnswer(faqRequest.getAnswer());
        FAQ updatedFAQ = faqRepository.save(faq);
        return new FAQResponse(updatedFAQ.getId(), updatedFAQ.getQuestion(), updatedFAQ.getAnswer());
    }

    @Override
    public void deleteFAQ(Long id) {
        FAQ faq = faqRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("FAQ not found with id " + id));
        faqRepository.delete(faq);
    }

    @Override
    public List<FAQResponse> createFAQs(List<FAQRequest> faqRequests) {
        List<FAQ> faqs = faqRequests.stream()
                .map(faqRequest -> {
                    FAQ faq = new FAQ();
                    faq.setQuestion(faqRequest.getQuestion());
                    faq.setAnswer(faqRequest.getAnswer());
                    return faq;
                })
                .collect(Collectors.toList());

        faqRepository.saveAll(faqs); // Save all FAQs in bulk

        // Convert the saved FAQs to FAQResponse
        return faqs.stream()
                .map(faq -> new FAQResponse(faq.getId(), faq.getQuestion(), faq.getAnswer()))
                .collect(Collectors.toList());
    }
}
