package com.weatherapp.Weatherly.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.weatherapp.Weatherly.Service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1")
public class WeatherController {
	
	@Autowired
	WeatherService weatherService;

	@GetMapping("/data")
	public String hello() {
		return "hello";
	}
	
//	@GetMapping("/weather")
//	public String getWeatherDatastr() {
//		return weatherService.fetchWeatherData();
//	}
	@GetMapping("/weather")
	public String getWeatherData() {
		return weatherService.fetchWeatherData();
	}
		
	
	
}
