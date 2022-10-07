package com.carrental.builders;

import com.carrental.carRepository.Car;
import com.carrental.carRepository.CarType;

public class CarBuilder {

    private Car car = new Car();

    public CarBuilder withModel(String model) {
        car.setModel(model);
        return this;
    }

    public CarBuilder withType(CarType type) {
        car.setType(type);
        return this;
    }

    public CarBuilder withMileage(int mileage) {
        car.setMileage(mileage);
        return this;
    }

    public CarBuilder withPrice(double price) {
        car.setPrice(price);
        return this;
    }

    public Car build() {
        return car;
    }

}
