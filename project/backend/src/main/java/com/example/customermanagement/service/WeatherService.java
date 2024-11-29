package com.example.customermanagement.service;

import com.example.customermanagement.dto.WeatherData;
import java.util.Optional;

public interface WeatherService {
    Optional<WeatherData> getWeatherByLocation(String location);
}