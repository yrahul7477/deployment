package com.santu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.santu.entities.FamilyInformation;

public interface FamilyInformationRepository extends JpaRepository<FamilyInformation, Long> {
}
