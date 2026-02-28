package com.ems.leucine.demo.service;

import com.ems.leucine.demo.entity.*;
import com.ems.leucine.demo.exception.ResourceNotFoundException;
import com.ems.leucine.demo.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    public Equipment create(Equipment equipment) {
        validateRule(equipment);
        return equipmentRepository.save(equipment);
    }

    public Equipment update(Long id, Equipment updated) {
        Equipment existing = equipmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Equipment not found"));

        validateRule(updated);

        existing.setName(updated.getName());
        existing.setStatus(updated.getStatus());
        existing.setLastCleanedDate(updated.getLastCleanedDate());
        existing.setType(updated.getType());

        return equipmentRepository.save(existing);
    }

    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }

    private void validateRule(Equipment equipment) {
        if (equipment.getStatus() == EquipmentStatus.ACTIVE) {
            long days = ChronoUnit.DAYS.between(
                    equipment.getLastCleanedDate(),
                    LocalDate.now());

            if (days > 30) {
                throw new RuntimeException(
                        "Cannot mark ACTIVE if last cleaned > 30 days");
            }
        }
    }
}