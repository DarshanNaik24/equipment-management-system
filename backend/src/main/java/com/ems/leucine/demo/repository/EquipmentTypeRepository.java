package com.ems.leucine.demo.repository;

import com.ems.leucine.demo.entity.EquipmentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentTypeRepository extends JpaRepository<EquipmentType, Long> {
}