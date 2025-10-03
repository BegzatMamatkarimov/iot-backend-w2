package com.example.iotbackend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class DeviceRequest {
    @NotBlank(message = "name не должен быть пустым")
    private String name;

    private String model;
    private Integer manufactureYear;
    private String description;

    @PositiveOrZero(message = "price должно быть >= 0")
    private Double price;

    // getters / setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public Integer getManufactureYear() { return manufactureYear; }
    public void setManufactureYear(Integer manufactureYear) { this.manufactureYear = manufactureYear; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}
