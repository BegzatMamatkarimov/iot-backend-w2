//package com.example.iotbackend.util;
//
//import com.example.iotbackend.model.Device;
//import com.example.iotbackend.repository.DeviceRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//    private final DeviceRepository repo;
//
//    public DataInitializer(DeviceRepository repo) { this.repo = repo; }
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (repo.count() == 0) {
//            Device d1 = new Device();
//            d1.setName("TempSensor-A1");
//            d1.setModel("TS-100");
//            d1.setManufactureYear(2024);
//            d1.setDescription("Датчик температуры (демо)");
//            d1.setPrice(29.99);
//            repo.save(d1);
//
//            Device d2 = new Device();
//            d2.setName("SmartPlug-X");
//            d2.setModel("SP-01");
//            d2.setManufactureYear(2023);
//            d2.setDescription("Умная розетка (демо)");
//            d2.setPrice(12.5);
//            repo.save(d2);
//        }
//    }
//}
