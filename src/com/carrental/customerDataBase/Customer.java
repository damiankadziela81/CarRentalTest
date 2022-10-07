package com.carrental.customerDataBase;

import com.carrental.carRepository.Car;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private String surName;
    private int numberOfRentals = 0;
    private double moneySpent = 0.0;
    private List<Car> carsRentedHistory = new ArrayList<>();

    public Customer(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getNumberOfRentals() {
        return numberOfRentals;
    }

    public void increaseNumberOfRentals(int increment) {
        if(increment > 0) this.numberOfRentals += increment;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public void increaseMoneySpent(double amount) {
        if (amount>0) this.moneySpent += amount;
    }

    public List<Car> getCarsRentedHistory() {
        return carsRentedHistory;
    }

    public void addCarToCurrentlyRented(Car car) {
        this.carsRentedHistory.add(car);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", numberOfRentals=" + numberOfRentals +
                ", moneySpent=" + moneySpent +
                '}' + '\n';
    }
}
