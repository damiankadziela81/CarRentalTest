package com.carrental.customerDataBase;

import com.carrental.carRepository.Car;

import java.util.List;

public class Customer {

    String name;
    String surName;
    int numberOfRentals = 0;
    double moneySpent = 0.0;

    List<Car> carsRentedCurrently;

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

    public List<Car> getCarsRentedCurrently() {
        return carsRentedCurrently;
    }

    public void addCarToCurrentlyRented(Car car) {
        this.carsRentedCurrently.add(car);
    }

    public void removeCarFromCurrentlyRented(Car car) {
        this.carsRentedCurrently.remove(car);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", numberOfRentals=" + numberOfRentals +
                ", moneySpent=" + moneySpent +
                '}';
    }
}
