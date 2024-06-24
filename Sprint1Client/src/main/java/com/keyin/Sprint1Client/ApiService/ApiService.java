package com.keyin.Sprint1Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.Sprint1Client.model.City;

import java.util.List;

public class ApiService {
    private final ApiClient apiClient;
    private final ObjectMapper objectMapper;

    public ApiService() {
        this.apiClient = new ApiClient();
        this.objectMapper = new ObjectMapper();
    }

    public List<City> getAllCities() throws Exception {
        String response = apiClient.getRequest("/cities");
        return objectMapper.readValue(response, objectMapper.getTypeFactory().constructCollectionType(List.class, City.class));
    }

    public City createCity(City city) throws Exception {
        String json = objectMapper.writeValueAsString(city);
        String response = apiClient.postRequest("/cities", json);
        return objectMapper.readValue(response, City.class);
    }

    // Similar methods for Passenger, Airport, and Aircraft
}
