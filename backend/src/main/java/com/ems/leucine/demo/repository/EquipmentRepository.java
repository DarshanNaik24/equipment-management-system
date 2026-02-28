package com.ems.leucine.demo.repository;

import com.ems.leucine.demo.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
}