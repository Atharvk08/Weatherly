package com.weatherapp.Weatherly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class WeatherlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherlyApplication.class, args);
	}

}
