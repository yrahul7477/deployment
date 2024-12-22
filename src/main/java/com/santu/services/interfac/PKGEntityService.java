package com.santu.services.interfac;


import com.santu.dto.request.PKGEntityRequest;
import com.santu.dto.response.PKGEntityResponse;

import java.util.List;

public interface PKGEntityService {

    PKGEntityResponse createPKGEntity(PKGEntityRequest pkgEntityRequest);

    List<PKGEntityResponse> getAllPKGEntities();

    PKGEntityResponse getPKGEntityById(Long id);

    PKGEntityResponse updatePKGEntity(Long id, PKGEntityRequest pkgEntityRequest);

    void deletePKGEntity(Long id);
}
