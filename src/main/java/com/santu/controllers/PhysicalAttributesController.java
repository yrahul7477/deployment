package com.santu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santu.dto.request.PhysicalAttributesRequestDTO;
import com.santu.dto.response.PhysicalAttributesResponseDTO;
import com.santu.services.interfac.PhysicalAttributesService;

@RestController
@RequestMapping("/api/physical-attributes")
public class PhysicalAttributesController {

    @Autowired
    private PhysicalAttributesService physicalAttributesService;

    @PostMapping
    public PhysicalAttributesResponseDTO savePhysicalAttributes(@RequestBody PhysicalAttributesRequestDTO requestDTO) {
        return physicalAttributesService.savePhysicalAttributes(requestDTO);
    }

    @GetMapping
    public List<PhysicalAttributesResponseDTO> getAllPhysicalAttributes() {
        return physicalAttributesService.getAllPhysicalAttributes();
    }

    @PutMapping("/{id}")
    public PhysicalAttributesResponseDTO updatePhysicalAttributes(
            @PathVariable Long id,
            @RequestBody PhysicalAttributesRequestDTO requestDTO) {
        return physicalAttributesService.updatePhysicalAttributes(id, requestDTO);
    }

    @GetMapping("/{id}")
    public PhysicalAttributesResponseDTO getPhysicalAttributesById(@PathVariable Long id) {
        return physicalAttributesService.getPhysicalAttributesById(id);
    }
}
