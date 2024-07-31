package com.gunes.thymeleafDemo.Model;


import java.util.List;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLaguage;
    private List<String> favoriteSystems;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteLaguage() {
        return favoriteLaguage;
    }

    public void setFavoriteLaguage(String favoriteLaguage) {
        this.favoriteLaguage = favoriteLaguage;
    }

    public List<String> getFavoriteSystems() {
        return favoriteSystems;
    }

    public void setFavoriteSystems(List<String> favoriteSystems) {
        this.favoriteSystems = favoriteSystems;
    }
}
