package com.example.iotbackend.service;

import com.example.iotbackend.model.Device;
import com.example.iotbackend.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {
    private final DeviceRepository repo;

    public DeviceService(DeviceRepository repo) {
        this.repo = repo;
    }

    public List<Device> findAll() { return repo.findAll(); }
    public Optional<Device> findById(Long id) { return repo.findById(id); }
    public Device save(Device device) { return repo.save(device); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
