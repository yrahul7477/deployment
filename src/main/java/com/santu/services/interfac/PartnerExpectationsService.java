package com.santu.services.interfac;



import java.util.List;

import com.santu.dto.request.PartnerExpectationsRequestDTO;
import com.santu.dto.response.PartnerExpectationsResponseDTO;

public interface PartnerExpectationsService {
    PartnerExpectationsResponseDTO savePartnerExpectations(PartnerExpectationsRequestDTO requestDTO);
    PartnerExpectationsResponseDTO updatePartnerExpectations(Long id, PartnerExpectationsRequestDTO requestDTO);
    List<PartnerExpectationsResponseDTO> getAllPartnerExpectations();
    PartnerExpectationsResponseDTO getPartnerExpectationsById(Long id);
}
