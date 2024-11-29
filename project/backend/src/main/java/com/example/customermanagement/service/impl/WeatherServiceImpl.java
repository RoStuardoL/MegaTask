package com.example.customermanagement.service.impl;

import com.example.customermanagement.dto.WeatherData;
import com.example.customermanagement.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final RestTemplate restTemplate;
    
    @Value("${weather.api.url}")
    private String weatherApiUrl;
    
    @Value("${weather.api.key}")
    private String apiKey;

    @Override
    public Optional<WeatherData> getWeatherByLocation(String location) {
        try {
            String url = UriComponentsBuilder.fromHttpUrl(weatherApiUrl)
                .queryParam("q", location)
                .queryParam("appid", apiKey)
                .queryParam("units", "metric")
                .build()
                .toUriString();

            WeatherData weatherData = restTemplate.getForObject(url, WeatherData.class);
            return Optional.ofNullable(weatherData);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}