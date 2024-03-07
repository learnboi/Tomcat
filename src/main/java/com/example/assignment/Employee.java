package com.example.assignment;

public class Employee {
    @Override
    public String toString() {
        return "{Id="+id+" Name="+name+" City="+city+"}";
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String city;
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
