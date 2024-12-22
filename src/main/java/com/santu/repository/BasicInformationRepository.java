package com.santu.repository;

import com.santu.entities.BasicInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicInformationRepository extends JpaRepository<BasicInformation, Long> {
    // Custom queries can be added here if needed
}
