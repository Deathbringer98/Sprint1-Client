package com.keyin.Sprint1Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.Sprint1Client.model.City;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ApiServiceTest {
    private ApiService apiService;
    private ApiClient apiClientMock;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        apiClientMock = Mockito.mock(ApiClient.class);
        objectMapper = new ObjectMapper();
        apiService = new ApiService(apiClientMock, objectMapper);
    }

    @Test
    public void testGetAllCities() throws Exception {
        String jsonResponse = "[{\"id\":1,\"name\":\"Test City\",\"state\":\"Test State\",\"population\":1000}]";
        when(apiClientMock.getRequest("/cities")).thenReturn(jsonResponse);

        List<City> cities = apiService.getAllCities();

        assertEquals(1, cities.size());
        assertEquals("Test City", cities.get(0).getName());
    }

    @Test
    public void testCreateCity() throws Exception {
        String jsonResponse = "{\"id\":1,\"name\":\"Test City\",\"state\":\"Test State\",\"population\":1000}";
        when(apiClientMock.postRequest(eq("/cities"), anyString())).thenReturn(jsonResponse);

        City city = new City();
        city.setName("Test City");
        city.setState("Test State");
        city.setPopulation(1000);

        City createdCity = apiService.createCity(city);

        assertEquals("Test City", createdCity.getName());
    }
}
