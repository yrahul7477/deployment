package com.santu.repository;
 // Change the package name accordingly

import com.santu.entities.PKGEntity;  // Updated the import to reflect the correct entity class
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PKGEntityRepository extends JpaRepository<PKGEntity, Long> {  // Changed to PKGEntityRepository and PKGEntity entity class
}

