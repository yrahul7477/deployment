package com.santu.services.interfac;





import java.util.List;

import com.santu.dto.request.FamilyInformationRequestDTO;
import com.santu.dto.response.FamilyInformationResponseDTO;

public interface FamilyInformationService {
    FamilyInformationResponseDTO saveFamilyInformation(FamilyInformationRequestDTO requestDTO);
    List<FamilyInformationResponseDTO> getAllFamilyInformation();
    FamilyInformationResponseDTO getFamilyInformationById(Long id);
    FamilyInformationResponseDTO updateFamilyInformation(Long id, FamilyInformationRequestDTO requestDTO);

}

