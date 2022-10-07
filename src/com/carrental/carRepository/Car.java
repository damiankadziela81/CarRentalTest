package com.carrental.carRepository;

import com.carrental.customerDataBase.Customer;

import java.util.Objects;

public class Car {

    private String model;
    private CarType type;
    private int mileage;
    private Customer rentedBy;

    private boolean isRented = false;


    private double price;

    public Car() {
    }

    public Car(String model, CarType type, int mileage, Customer rentedBy, double price) {
        this.model = model;
        this.type = type;
        this.mileage = mileage;
        this.rentedBy = rentedBy;
        this.price = price;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }



    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", type=" + type +
                ", mileage=" + mileage +
                ", rentedBy=" + rentedBy +
                ", pricePerDay=" + price +
                ", isRented=" + isRented +
                '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return mileage == car.mileage && Double.compare(car.price, price) == 0 && model.equals(car.model) && type == car.type && Objects.equals(rentedBy, car.rentedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, type, mileage, rentedBy, price);
    }
}
