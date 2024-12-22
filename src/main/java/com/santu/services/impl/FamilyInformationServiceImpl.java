package com.santu.services.impl;




import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santu.dto.request.FamilyInformationRequestDTO;
import com.santu.dto.response.FamilyInformationResponseDTO;
import com.santu.entities.FamilyInformation;
import com.santu.entities.User;
import com.santu.repository.FamilyInformationRepository;
import com.santu.repository.UserRepository;
import com.santu.services.interfac.FamilyInformationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamilyInformationServiceImpl implements FamilyInformationService {

    @Autowired
    private FamilyInformationRepository familyInformationRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public FamilyInformationResponseDTO saveFamilyInformation(FamilyInformationRequestDTO requestDTO) {
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        FamilyInformation familyInformation = new FamilyInformation();
        BeanUtils.copyProperties(requestDTO, familyInformation);
        familyInformation.setUser(user);

        FamilyInformation savedEntity = familyInformationRepository.save(familyInformation);

        FamilyInformationResponseDTO responseDTO = new FamilyInformationResponseDTO();
        BeanUtils.copyProperties(savedEntity, responseDTO);
        responseDTO.setUserId(user.getId());

        return responseDTO;
    }

    @Override
    public List<FamilyInformationResponseDTO> getAllFamilyInformation() {
        return familyInformationRepository.findAll().stream().map(familyInformation -> {
            FamilyInformationResponseDTO responseDTO = new FamilyInformationResponseDTO();
            BeanUtils.copyProperties(familyInformation, responseDTO);
            responseDTO.setUserId(familyInformation.getUser().getId());
            return responseDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public FamilyInformationResponseDTO getFamilyInformationById(Long id) {
        FamilyInformation familyInformation = familyInformationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family information ID"));

        FamilyInformationResponseDTO responseDTO = new FamilyInformationResponseDTO();
        BeanUtils.copyProperties(familyInformation, responseDTO);
        responseDTO.setUserId(familyInformation.getUser().getId());

        return responseDTO;
    }
    
    
    @Override
    public FamilyInformationResponseDTO updateFamilyInformation(Long id, FamilyInformationRequestDTO requestDTO) {
        FamilyInformation familyInformation = familyInformationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family information ID"));

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        // Update entity fields
        familyInformation.setFathersName(requestDTO.getFathersName());
        familyInformation.setFathersProfession(requestDTO.getFathersProfession());
        familyInformation.setFathersContact(requestDTO.getFathersContact());
        familyInformation.setMothersName(requestDTO.getMothersName());
        familyInformation.setMothersProfession(requestDTO.getMothersProfession());
        familyInformation.setMothersContact(requestDTO.getMothersContact());
        familyInformation.setTotalBrother(requestDTO.getTotalBrother());
        familyInformation.setTotalSister(requestDTO.getTotalSister());
        familyInformation.setUser(user);

        FamilyInformation updatedEntity = familyInformationRepository.save(familyInformation);

        FamilyInformationResponseDTO responseDTO = new FamilyInformationResponseDTO();
        BeanUtils.copyProperties(updatedEntity, responseDTO);
        responseDTO.setUserId(user.getId());

        return responseDTO;
    }
}

