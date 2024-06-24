package com.keyin.Sprint1Client.model;

public class City {
    private Long id;
    private String name;
    private String state;
    private int population;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public int getPopulation() {
        return population;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{id=" + id + ", name='" + name + "', state='" + state + "', population=" + population + '}';
    }
}
