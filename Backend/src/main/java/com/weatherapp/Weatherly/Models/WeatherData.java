package com.weatherapp.Weatherly.Models;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherData {

	
	
	
	@Id
	private String id ;
    private String name;

    // Main should map the temperature-related fields (e.g., temp, feels_like, etc.)
    private Map<String, Double> main;

    // Weather is an array, so it should be a List of Maps
    private List<Map<String, String>> weather;

    private String dt; // DateTime in Unix timestamp
    
	
//	private Map<String ,Double> wind;
	
	
//	private double temp;
//	private double temp_min;
//	private double temp_max;
//	private double humidity;
	
//	private double feels_like;
//	private String condition;
}


