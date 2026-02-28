package com.ems.leucine.demo.controller;

import com.ems.leucine.demo.entity.Equipment;
import com.ems.leucine.demo.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
@CrossOrigin
public class EquipmentController {

    private final EquipmentService service;

    public EquipmentController(EquipmentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Equipment> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Equipment create(@RequestBody Equipment equipment) {
        return service.create(equipment);
    }

    @PutMapping("/{id}")
    public Equipment update(
            @PathVariable Long id,
            @RequestBody Equipment equipment) {
        return service.update(id, equipment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}