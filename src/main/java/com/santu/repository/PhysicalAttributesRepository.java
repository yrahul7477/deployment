package com.santu.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.santu.entities.PhysicalAttributes;

public interface PhysicalAttributesRepository extends JpaRepository<PhysicalAttributes, Long> {
}

