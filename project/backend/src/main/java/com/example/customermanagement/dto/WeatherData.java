package com.example.customermanagement.dto;

import lombok.Data;

@Data
public class WeatherData {
    private double temperature;
    private String condition;
    private String location;
}