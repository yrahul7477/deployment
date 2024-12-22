package com.santu.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.santu.dto.request.FamilyInformationRequestDTO;
import com.santu.dto.response.FamilyInformationResponseDTO;
import com.santu.services.interfac.FamilyInformationService;

import java.util.List;

@RestController
@RequestMapping("/api/family-info")
public class FamilyInformationController {

    @Autowired
    private FamilyInformationService familyInformationService;

    @PostMapping
    public FamilyInformationResponseDTO saveFamilyInformation(@RequestBody FamilyInformationRequestDTO requestDTO) {
        return familyInformationService.saveFamilyInformation(requestDTO);
    }

    @GetMapping
    public List<FamilyInformationResponseDTO> getAllFamilyInformation() {
        return familyInformationService.getAllFamilyInformation();
    }

    @GetMapping("/{id}")
    public FamilyInformationResponseDTO getFamilyInformationById(@PathVariable Long id) {
        return familyInformationService.getFamilyInformationById(id);
    }

    @PutMapping("/{id}")
    public FamilyInformationResponseDTO updateFamilyInformation(
            @PathVariable Long id,
            @RequestBody FamilyInformationRequestDTO requestDTO) {
        return familyInformationService.updateFamilyInformation(id, requestDTO);
    }
}

