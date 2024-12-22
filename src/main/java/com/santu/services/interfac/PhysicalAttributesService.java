package com.santu.services.interfac;

import java.util.List;

import com.santu.dto.request.PhysicalAttributesRequestDTO;
import com.santu.dto.response.PhysicalAttributesResponseDTO;

public interface PhysicalAttributesService {
    PhysicalAttributesResponseDTO savePhysicalAttributes(PhysicalAttributesRequestDTO requestDTO);
    List<PhysicalAttributesResponseDTO> getAllPhysicalAttributes();
    PhysicalAttributesResponseDTO updatePhysicalAttributes(Long id, PhysicalAttributesRequestDTO requestDTO);
    PhysicalAttributesResponseDTO getPhysicalAttributesById(Long id);
}

