package org.example;

public class Customer {
    String id;
    String name;
    String city;
    Gender gender;
    int number_of_purchases;

    public Customer(String id, String name, String city, Gender gender, int number_of_purchases) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.number_of_purchases = number_of_purchases;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", number_of_purchases=" + number_of_purchases +
                '}';
    }
}
