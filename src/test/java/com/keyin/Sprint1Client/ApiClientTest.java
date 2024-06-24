package com.keyin.Sprint1Client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ApiClientTest {
    private ApiClient apiClient;
    private HttpClient httpClientMock;
    private HttpResponse<String> httpResponseMock;

    @BeforeEach
    public void setUp() {
        httpClientMock = Mockito.mock(HttpClient.class);
        httpResponseMock = Mockito.mock(HttpResponse.class);
        apiClient = new ApiClient() {
            @Override
            protected HttpClient createHttpClient() {
                return httpClientMock;
            }
        };
    }

    @Test
    public void testGetRequest() throws Exception {
        when(httpResponseMock.body()).thenReturn("{\"id\":1,\"name\":\"Test City\"}");
        when(httpClientMock.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponseMock);

        String response = apiClient.getRequest("/test");

        assertNotNull(response);
        assertEquals("{\"id\":1,\"name\":\"Test City\"}", response);
    }

    @Test
    public void testPostRequest() throws Exception {
        when(httpResponseMock.body()).thenReturn("{\"id\":1,\"name\":\"Test City\"}");
        when(httpClientMock.send(any(HttpRequest.class), any(HttpResponse.BodyHandler.class)))
                .thenReturn(httpResponseMock);

        String json = "{\"name\":\"Test City\"}";
        String response = apiClient.postRequest("/test", json);

        assertNotNull(response);
        assertEquals("{\"id\":1,\"name\":\"Test City\"}", response);
    }
}
