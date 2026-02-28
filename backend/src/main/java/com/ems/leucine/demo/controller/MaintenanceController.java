package com.ems.leucine.demo.controller;

import com.ems.leucine.demo.entity.MaintenanceLog;
import com.ems.leucine.demo.service.MaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
@CrossOrigin
public class MaintenanceController {

    private final MaintenanceService service;

    public MaintenanceController(MaintenanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<MaintenanceLog> getAll() {
        return service.getAll();
    }

    @PostMapping
    public MaintenanceLog create(@RequestBody MaintenanceLog log) {
        return service.create(log);
    }
}