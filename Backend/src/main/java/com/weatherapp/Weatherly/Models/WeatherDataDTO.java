package com.weatherapp.Weatherly.Models;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WeatherDataDTO {

	private String city;
	private double temp;
	private double feels_like;
	private String condition;
	private String timestamp;

	public String toJSON() {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(this);
		}catch(JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
	}
}

