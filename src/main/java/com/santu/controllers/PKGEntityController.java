package com.santu.controllers;  // Updated package name according to your structure


import com.santu.dto.request.PKGEntityRequest;
import com.santu.dto.response.PKGEntityResponse;
import com.santu.services.interfac.PKGEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")

@RestController
@RequestMapping("/api/packages")  // Updated to reflect the correct API endpoint
public class PKGEntityController {  // Updated controller name to reflect the entity name

    @Autowired
    private PKGEntityService pkgEntityService;  // Updated service name

    @PostMapping
    public ResponseEntity<PKGEntityResponse> createPKGEntity(@Valid @RequestBody PKGEntityRequest pkgEntityRequest) {
        PKGEntityResponse pkgEntityResponse = pkgEntityService.createPKGEntity(pkgEntityRequest);
        return ResponseEntity.ok(pkgEntityResponse);
    }

    @GetMapping
    public ResponseEntity<List<PKGEntityResponse>> getAllPKGEntities() {
        List<PKGEntityResponse> pkgEntityResponses = pkgEntityService.getAllPKGEntities();
        return ResponseEntity.ok(pkgEntityResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PKGEntityResponse> getPKGEntityById(@PathVariable Long id) {
        PKGEntityResponse pkgEntityResponse = pkgEntityService.getPKGEntityById(id);
        return ResponseEntity.ok(pkgEntityResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PKGEntityResponse> updatePKGEntity(@PathVariable Long id, @Valid @RequestBody PKGEntityRequest pkgEntityRequest) {
        PKGEntityResponse pkgEntityResponse = pkgEntityService.updatePKGEntity(id, pkgEntityRequest);
        return ResponseEntity.ok(pkgEntityResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePKGEntity(@PathVariable Long id) {
        pkgEntityService.deletePKGEntity(id);
        return ResponseEntity.noContent().build();
    }
}
