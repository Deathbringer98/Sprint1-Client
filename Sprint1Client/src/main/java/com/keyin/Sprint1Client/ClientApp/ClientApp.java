package com.keyin.Sprint1Client;

import com.keyin.Sprint1Client.model.City;

import java.util.Scanner;

public class ClientApp {
    private final ApiService apiService;
    private final Scanner scanner;

    public ClientApp() {
        this.apiService = new ApiService();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        ClientApp app = new ClientApp();
        app.run();
    }

    private void run() {
        while (true) {
            System.out.println("1. List all cities");
            System.out.println("2. Create a city");
            // Add options for other entities and functionalities
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        listAllCities();
                        break;
                    case 2:
                        createCity();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void listAllCities() throws Exception {
        var cities = apiService.getAllCities();
        for (var city : cities) {
            System.out.println(city);
        }
    }

    private void createCity() throws Exception {
        System.out.println("Enter city name:");
        String name = scanner.nextLine();
        System.out.println("Enter city state:");
        String state = scanner.nextLine();
        System.out.println("Enter city population:");
        int population = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        City city = new City();
        city.setName(name);
        city.setState(state);
        city.setPopulation(population);

        City createdCity = apiService.createCity(city);
        System.out.println("Created city: " + createdCity);
    }

    // Similar methods for Passenger, Airport, and Aircraft
}
