package com.santu.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.santu.dto.request.PartnerExpectationsRequestDTO;
import com.santu.dto.response.PartnerExpectationsResponseDTO;
import com.santu.services.interfac.PartnerExpectationsService;

import java.util.List;

@RestController
@RequestMapping("/api/partner-expectations")
public class PartnerExpectationsController {

    @Autowired
    private PartnerExpectationsService partnerExpectationsService;

    @PostMapping
    public PartnerExpectationsResponseDTO savePartnerExpectations(@RequestBody PartnerExpectationsRequestDTO requestDTO) {
        return partnerExpectationsService.savePartnerExpectations(requestDTO);
    }

    @PutMapping("/{id}")
    public PartnerExpectationsResponseDTO updatePartnerExpectations(
            @PathVariable Long id,
            @RequestBody PartnerExpectationsRequestDTO requestDTO) {
        return partnerExpectationsService.updatePartnerExpectations(id, requestDTO);
    }

    @GetMapping
    public List<PartnerExpectationsResponseDTO> getAllPartnerExpectations() {
        return partnerExpectationsService.getAllPartnerExpectations();
    }

    @GetMapping("/{id}")
    public PartnerExpectationsResponseDTO getPartnerExpectationsById(@PathVariable Long id) {
        return partnerExpectationsService.getPartnerExpectationsById(id);
    }
}

