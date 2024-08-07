package org.example;

public class ApiData {
    String name;
    String description;
    String url;

    public ApiData(String name,  String url ,String description) {
        this.name = name;
        this.url = url;
        this.description = description;

    }

    @Override
    public String toString() {
        return "Name: " + name + ", Url: " + url + ", Description: " + description;
    }
}
