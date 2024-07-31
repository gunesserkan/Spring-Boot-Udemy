package com.gunes.mvc.model;

import jakarta.validation.constraints.*;

import java.util.List;

public class Customer {

    private String firstName;

    @NotNull(message = " gerekli alan")
    @Size(min = 3, message = "gerekli alan")
    private String lastName;

    @Min(value = 18, message = "18den büyük olmalı")
    @Max(value = 30, message = "30'dan küçük olmalı")
    private int age;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "sadece 5 karakter olmalıdır!")
    private String postCode;

    private String favoriteLanguage;

    private List<String> favoriteSystems;

    public Customer() {
    }

    public Customer(String firstName, String lastName, int age, String postCode, String favoriteLanguage, List<String> favoriteSystems) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.postCode = postCode;
        this.favoriteLanguage = favoriteLanguage;
        this.favoriteSystems = favoriteSystems;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "sadece 5 karakter olmalıdır!") String getPostCode() {
        return postCode;
    }

    public void setPostCode(@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "sadece 5 karakter olmalıdır!") String postCode) {
        this.postCode = postCode;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public List<String> getFavoriteSystems() {
        return favoriteSystems;
    }

    public void setFavoriteSystems(List<String> favoriteSystems) {
        this.favoriteSystems = favoriteSystems;
    }
}
