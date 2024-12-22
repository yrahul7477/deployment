package com.santu.services.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santu.dto.request.PhysicalAttributesRequestDTO;
import com.santu.dto.response.PhysicalAttributesResponseDTO;
import com.santu.entities.PhysicalAttributes;
import com.santu.entities.User;
import com.santu.repository.PhysicalAttributesRepository;
import com.santu.repository.UserRepository;
import com.santu.services.interfac.PhysicalAttributesService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhysicalAttributesServiceImpl implements PhysicalAttributesService {

    @Autowired
    private PhysicalAttributesRepository physicalAttributesRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PhysicalAttributesResponseDTO savePhysicalAttributes(PhysicalAttributesRequestDTO requestDTO) {
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        PhysicalAttributes physicalAttributes = new PhysicalAttributes();
        BeanUtils.copyProperties(requestDTO, physicalAttributes);
        physicalAttributes.setUser(user);

        PhysicalAttributes savedEntity = physicalAttributesRepository.save(physicalAttributes);

        PhysicalAttributesResponseDTO responseDTO = new PhysicalAttributesResponseDTO();
        BeanUtils.copyProperties(savedEntity, responseDTO);
        responseDTO.setUserId(user.getId());

        return responseDTO;
    }

    @Override
    public List<PhysicalAttributesResponseDTO> getAllPhysicalAttributes() {
        return physicalAttributesRepository.findAll().stream().map(entity -> {
            PhysicalAttributesResponseDTO responseDTO = new PhysicalAttributesResponseDTO();
            BeanUtils.copyProperties(entity, responseDTO);
            responseDTO.setUserId(entity.getUser().getId());
            return responseDTO;
        }).collect(Collectors.toList());
    }
    
    
    
    @Override
    public PhysicalAttributesResponseDTO updatePhysicalAttributes(Long id, PhysicalAttributesRequestDTO requestDTO) {
        PhysicalAttributes existingAttributes = physicalAttributesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Physical attributes not found"));

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        BeanUtils.copyProperties(requestDTO, existingAttributes, "id");
        existingAttributes.setUser(user);

        PhysicalAttributes updatedAttributes = physicalAttributesRepository.save(existingAttributes);

        PhysicalAttributesResponseDTO responseDTO = new PhysicalAttributesResponseDTO();
        BeanUtils.copyProperties(updatedAttributes, responseDTO);
        responseDTO.setUserId(user.getId());

        return responseDTO;
    }

    @Override
    public PhysicalAttributesResponseDTO getPhysicalAttributesById(Long id) {
        PhysicalAttributes attributes = physicalAttributesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Physical attributes not found"));

        PhysicalAttributesResponseDTO responseDTO = new PhysicalAttributesResponseDTO();
        BeanUtils.copyProperties(attributes, responseDTO);
        responseDTO.setUserId(attributes.getUser().getId());

        return responseDTO;
    }

}

