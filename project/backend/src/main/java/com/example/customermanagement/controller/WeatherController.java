package com.example.customermanagement.controller;

import com.example.customermanagement.dto.WeatherData;
import com.example.customermanagement.service.WeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Weather", description = "Weather information endpoints")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping
    @Operation(summary = "Get weather information by location")
    public ResponseEntity<WeatherData> getWeatherByLocation(
        @RequestParam String location
    ) {
        return weatherService.getWeatherByLocation(location)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}