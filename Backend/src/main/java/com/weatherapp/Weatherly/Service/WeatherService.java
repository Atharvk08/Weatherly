package com.weatherapp.Weatherly.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapp.Weatherly.Models.WeatherData;
import com.weatherapp.Weatherly.Models.WeatherDataDTO;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

@Service
public class WeatherService {

	String URL = "https://api.openweathermap.org/data/2.5/weather";
	String API_KEY = "9e56ee6e81fd1cbbc4e3575ebbe0dccd";
	
	
	private final OkHttpClient client = new OkHttpClient();
	
	public String fetchWeatherData() {
		
//		String data= callOpenWeatherMapAPI();
		WeatherData data= callOpenWeatherMap();
		
		System.out.println(data);
		
		return convertToWeatherDataDTO(data);
		
	}

	private String convertToWeatherDataDTO(WeatherData data) {
		WeatherDataDTO dtoData= new WeatherDataDTO("Mumbai",data.getMain().get("temp"),data.getMain().get("feels_like"),"GOOD",data.getDt());
		return dtoData.toJSON();
	}

	private String callOpenWeatherMapAPI() {
		
		String city = "Mumbai";
		
		String query = URL + "?q=%s&appid=%s";

		query = String.format(query, city,API_KEY);
		
		Request request =new Request.Builder()
				.url(query)
				.build();
		
		try(Response response = client.newCall(request).execute()){
			if(response.isSuccessful()) {
				return response.body().string();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	private WeatherData callOpenWeatherMap() {
		
		String city = "Mumbai";
		
		String query = URL + "?q=%s&appid=%s";

		query = String.format(query, city,API_KEY);
		
		Request request =new Request.Builder()
				.url(query)
				.build();
		
		try(Response response = client.newCall(request).execute()){
			if(response.isSuccessful()) {
				return convertToWeatherData(response.body());
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
	}

	private WeatherData convertToWeatherData(ResponseBody body) {

		ObjectMapper objMapper = new ObjectMapper();
		
		WeatherData data;
		try {
		    WeatherData weatherData = objMapper.readValue(body.string(), WeatherData.class);

		    System.out.println("City: " + weatherData.getName());
		    System.out.println("Temperature: " + weatherData.getMain().get("temp"));
		    System.out.println("Weather Condition: " + weatherData.getWeather().get(0).get("main"));

			return weatherData;
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
