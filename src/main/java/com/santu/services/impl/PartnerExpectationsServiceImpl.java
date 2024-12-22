package com.santu.services.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santu.dto.request.PartnerExpectationsRequestDTO;
import com.santu.dto.response.PartnerExpectationsResponseDTO;
import com.santu.entities.PartnerExpectations;
import com.santu.entities.User;
import com.santu.repository.PartnerExpectationsRepository;
import com.santu.repository.UserRepository;
import com.santu.services.interfac.PartnerExpectationsService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerExpectationsServiceImpl implements PartnerExpectationsService {

    @Autowired
    private PartnerExpectationsRepository partnerExpectationsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PartnerExpectationsResponseDTO savePartnerExpectations(PartnerExpectationsRequestDTO requestDTO) {
        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        PartnerExpectations partnerExpectations = new PartnerExpectations();
        BeanUtils.copyProperties(requestDTO, partnerExpectations);
        partnerExpectations.setUser(user);

        PartnerExpectations savedEntity = partnerExpectationsRepository.save(partnerExpectations);

        PartnerExpectationsResponseDTO responseDTO = new PartnerExpectationsResponseDTO();
        BeanUtils.copyProperties(savedEntity, responseDTO);
        responseDTO.setUserId(user.getId());

        return responseDTO;
    }

    @Override
    public PartnerExpectationsResponseDTO updatePartnerExpectations(Long id, PartnerExpectationsRequestDTO requestDTO) {
        PartnerExpectations existingEntity = partnerExpectationsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Partner expectations not found"));

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));

        BeanUtils.copyProperties(requestDTO, existingEntity, "id");
        existingEntity.setUser(user);

        PartnerExpectations updatedEntity = partnerExpectationsRepository.save(existingEntity);

        PartnerExpectationsResponseDTO responseDTO = new PartnerExpectationsResponseDTO();
        BeanUtils.copyProperties(updatedEntity, responseDTO);
        responseDTO.setUserId(user.getId());

        return responseDTO;
    }

    @Override
    public List<PartnerExpectationsResponseDTO> getAllPartnerExpectations() {
        return partnerExpectationsRepository.findAll().stream().map(entity -> {
            PartnerExpectationsResponseDTO responseDTO = new PartnerExpectationsResponseDTO();
            BeanUtils.copyProperties(entity, responseDTO);
            responseDTO.setUserId(entity.getUser().getId());
            return responseDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public PartnerExpectationsResponseDTO getPartnerExpectationsById(Long id) {
        PartnerExpectations entity = partnerExpectationsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Partner expectations not found"));

        PartnerExpectationsResponseDTO responseDTO = new PartnerExpectationsResponseDTO();
        BeanUtils.copyProperties(entity, responseDTO);
        responseDTO.setUserId(entity.getUser().getId());

        return responseDTO;
    }
}
