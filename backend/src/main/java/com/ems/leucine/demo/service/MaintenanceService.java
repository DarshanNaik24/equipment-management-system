package com.ems.leucine.demo.service;

import com.ems.leucine.demo.entity.MaintenanceLog;
import com.ems.leucine.demo.repository.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {

    private final MaintenanceRepository repository;

    public MaintenanceService(MaintenanceRepository repository) {
        this.repository = repository;
    }

    public List<MaintenanceLog> getAll() {
        return repository.findAll();
    }

    public MaintenanceLog create(MaintenanceLog log) {
        return repository.save(log);
    }
}