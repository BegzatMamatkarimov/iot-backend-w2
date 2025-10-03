package com.example.iotbackend.controller;

import com.example.iotbackend.dto.DeviceRequest;
import com.example.iotbackend.model.Device;
import com.example.iotbackend.service.DeviceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    private final DeviceService service;

    public DeviceController(DeviceService service) { this.service = service; }

    @GetMapping
    public List<Device> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getById(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Device> create(@Valid @RequestBody DeviceRequest req) {
        Device d = new Device();
        d.setName(req.getName());
        d.setModel(req.getModel());
        d.setManufactureYear(req.getManufactureYear());
        d.setDescription(req.getDescription());
        d.setPrice(req.getPrice());
        Device saved = service.save(d);
        return ResponseEntity.created(URI.create("/api/devices/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> update(@PathVariable Long id, @Valid @RequestBody DeviceRequest req) {
        return service.findById(id).map(existing -> {
            existing.setName(req.getName());
            existing.setModel(req.getModel());
            existing.setManufactureYear(req.getManufactureYear());
            existing.setDescription(req.getDescription());
            existing.setPrice(req.getPrice());
            Device saved = service.save(existing);
            return ResponseEntity.ok(saved);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
