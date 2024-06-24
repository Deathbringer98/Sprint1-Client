package com.keyin.Sprint1Client.model;

public class Airport {
    private Long id;
    private String name;
    private String code;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Airport{id=" + id + ", name='" + name + "', code='" + code + "'}";
    }
}
