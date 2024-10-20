package com.weatherapp.Weatherly.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherSummary {
	
	private String city;
	private double averageTemperature;
	private double maxTemperature;
	private double minTemperature;
	private String dominantCondition;
}


