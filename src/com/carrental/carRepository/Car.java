package com.carrental.carRepository;

import com.carrental.customerDataBase.Customer;

public class Car {

    private String model;
    private CarType type;
    private int mileage;
    private Customer rentedBy;

    private double pricePerDay;

    public Car() {
    }

    public Car(String model, CarType type, int mileage, Customer rentedBy, double pricePerDay) {
        this.model = model;
        this.type = type;
        this.mileage = mileage;
        this.rentedBy = rentedBy;
        this.pricePerDay = pricePerDay;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Customer getRentedBy() {
        return rentedBy;
    }

    public void setRentedBy(Customer rentedBy) {
        this.rentedBy = rentedBy;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type=" + type +
                ", mileage=" + mileage +
                ", rentedBy=" + rentedBy +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
