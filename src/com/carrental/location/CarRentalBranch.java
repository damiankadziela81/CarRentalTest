package com.carrental.location;

import com.carrental.carRepository.Car;
import com.carrental.customerDataBase.Customer;

import java.util.List;

public class CarRentalBranch {

    private String name;
    private String city;
    List<Car> carList;
    List<Customer> customerList;

    public CarRentalBranch(String name, String city, List<Car> carList, List<Customer> customerList) {
        this.name = name;
        this.city = city;
        this.carList = carList;
        this.customerList = customerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void addToCarList(Car car){
        this.carList.add(car);
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void addToCustomerList(Customer customer) {
        this.customerList.add(customer);
    }

    @Override
    public String toString() {
        return "CarRentalBranch{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", carList=" + carList +
                ", customerList=" + customerList +
                '}';
    }
}
