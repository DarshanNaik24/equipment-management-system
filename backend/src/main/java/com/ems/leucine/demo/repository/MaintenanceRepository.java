package com.ems.leucine.demo.repository;

import com.ems.leucine.demo.entity.MaintenanceLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaintenanceRepository extends JpaRepository<MaintenanceLog, Long> {
}