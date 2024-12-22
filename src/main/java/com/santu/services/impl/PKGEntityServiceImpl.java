package com.santu.services.impl;


import com.santu.dto.request.PKGEntityRequest;
import com.santu.dto.response.PKGEntityResponse;
import com.santu.entities.PKGEntity;
import com.santu.repository.PKGEntityRepository;
import com.santu.services.interfac.PKGEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PKGEntityServiceImpl implements PKGEntityService {  // Updated to the correct service implementation

    @Autowired
    private PKGEntityRepository pkgEntityRepository;  // Updated to the correct repository

    @Override
    public PKGEntityResponse createPKGEntity(PKGEntityRequest pkgEntityRequest) {
        PKGEntity pkgEntity = new PKGEntity();
        pkgEntity.setName(pkgEntityRequest.getName());
        pkgEntity.setRetailPrice(pkgEntityRequest.getRetailPrice());
        pkgEntity.setSellingPrice(pkgEntityRequest.getSellingPrice());
        pkgEntity.setFeatures(pkgEntityRequest.getFeatures());

        pkgEntity = pkgEntityRepository.save(pkgEntity);

        return new PKGEntityResponse(
                pkgEntity.getId(),
                pkgEntity.getName(),
                pkgEntity.getRetailPrice(),
                pkgEntity.getSellingPrice(),
                pkgEntity.getFeatures()
        );
    }

    @Override
    public List<PKGEntityResponse> getAllPKGEntities() {
        List<PKGEntity> pkgEntities = pkgEntityRepository.findAll();
        return pkgEntities.stream()
                .map(pkgEntity -> new PKGEntityResponse(
                        pkgEntity.getId(),
                        pkgEntity.getName(),
                        pkgEntity.getRetailPrice(),
                        pkgEntity.getSellingPrice(),
                        pkgEntity.getFeatures()))
                .collect(Collectors.toList());
    }

    @Override
    public PKGEntityResponse getPKGEntityById(Long id) {
        PKGEntity pkgEntity = pkgEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package entity not found"));
        return new PKGEntityResponse(
                pkgEntity.getId(),
                pkgEntity.getName(),
                pkgEntity.getRetailPrice(),
                pkgEntity.getSellingPrice(),
                pkgEntity.getFeatures()
        );
    }

    @Override
    public PKGEntityResponse updatePKGEntity(Long id, PKGEntityRequest pkgEntityRequest) {
        PKGEntity pkgEntity = pkgEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package entity not found"));

        pkgEntity.setName(pkgEntityRequest.getName());
        pkgEntity.setRetailPrice(pkgEntityRequest.getRetailPrice());
        pkgEntity.setSellingPrice(pkgEntityRequest.getSellingPrice());
        pkgEntity.setFeatures(pkgEntityRequest.getFeatures());

        pkgEntity = pkgEntityRepository.save(pkgEntity);

        return new PKGEntityResponse(
                pkgEntity.getId(),
                pkgEntity.getName(),
                pkgEntity.getRetailPrice(),
                pkgEntity.getSellingPrice(),
                pkgEntity.getFeatures()
        );
    }

    @Override
    public void deletePKGEntity(Long id) {
        PKGEntity pkgEntity = pkgEntityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package entity not found"));
        pkgEntityRepository.delete(pkgEntity);
    }
}
